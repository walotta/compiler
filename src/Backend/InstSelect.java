package Backend;

import Backend.ASMInst.*;
import Backend.ASMOperand.*;
import MIR.*;
import MIR.IRInstruction.*;
import MIR.IRtype.IRClassType;
import MIR.IRtype.IRPointerType;
import MIR.Module;
import MIR.Operand.*;
import Util.error.compilerError;
import Util.position;
import com.sun.jdi.ClassType;

import java.util.ArrayList;

public class InstSelect implements IRVisitor {
    private ASMModule asmModule;
    private int funcCnt=0;
    private ASMFunction currentFunc;
    private ASMBlock currentBlock;
    private final PhysicalReg stackHeaderReg=new PhysicalReg(2);
    private Module oriModule;

    private ASMReg transIROperand(IROperand irOperand){
        if(irOperand instanceof BoolConstant){
            if(((BoolConstant)irOperand).value) {
                ASMReg ret=currentFunc.getTmpReg();
                currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,ret,new Immediate(1)));
                return ret;
            }
            else
                return new PhysicalReg(0);
        }else if(irOperand instanceof globalVariable){
            throw new compilerError("globalVariable todo",new position(0,0));
        }else if(irOperand instanceof IntConstant){
            ASMReg ret=currentFunc.getTmpReg();
            currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,ret,new Immediate(((IntConstant)irOperand).value)));
            return ret;
        }else if(irOperand instanceof NullptrConstant){
            return new PhysicalReg(0);
        }else if(irOperand instanceof Register){
            return currentFunc.getReg((Register) irOperand);
        }else if(irOperand instanceof StringConstant){
            throw new compilerError("String todo",new position(0,0));
        }else{
            throw new compilerError("cannot deal with Label",new position(0,0));
        }
    }

    private int getFuncCnt(){
        int ret=funcCnt;
        funcCnt++;
        return ret;
    }
    
    public InstSelect(){
        currentFunc=null;
    }

    public ASMModule run(Module IRModule){
        oriModule=IRModule;
        asmModule=new ASMModule();
        IRModule.accept(this);
        return asmModule;
    }

    @Override
    public Object visit(Module it){
        it.functions.forEach((funcName,irFunc)->{
            if(!irFunc.isBuiltin){
                ASMFunction genFunc=(ASMFunction) irFunc.accept(this);
                asmModule.funcs.add(genFunc);
            }
        });
        //todo classes
        //todo globalVars
        //todo stringConst
        //todo initFuncs
        return null;
    }

    @Override
    public Object visit(Function it){
        currentFunc=new ASMFunction(it.funcName,getFuncCnt());
        ASMBlock loadParasBlock=new ASMBlock(new ASMLabel(currentFunc,"FuncInit"));

        loadParasBlock.insts.add(new ASMCalInst(ASMCalInst.op.addi,new PhysicalReg(2),new PhysicalReg(2),new FuncStackSize(it.funcName,0,false)));
        //define or load paras
        for(int i=0;i<it.paras.size();i++){
            if(i<8){
                //x10-x17
                currentFunc.defineReg(it.paras.get(i),new PhysicalReg(10+i));
            }else{
                currentFunc.stackManager.alloca(4);
                ASMReg vR=transIROperand(it.paras.get(i));
                loadParasBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,vR,stackHeaderReg,new Immediate(4*i)));
            }
        }
        int callerAddr=currentFunc.stackManager.alloca(4);
        currentFunc.callerAddr=callerAddr;
        loadParasBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sw,new PhysicalReg(1),stackHeaderReg,new Immediate(callerAddr)));
        currentFunc.blocks.add(loadParasBlock);
        //translate blocks
        it.Blocks.forEach(block->{
            block.accept(this);
        });
        return currentFunc;
    }

    @Override
    public Object visit(ClassUnit it){
        return null;
    }

    @Override
    public Object visit(globalVariable it){
        return null;
    }

    @Override
    public Object visit(StringConstant it){
        return null;
    }

    @Override
    public Object visit(BasicBlock it){
        currentBlock=new ASMBlock(new ASMLabel(currentFunc,it.label.getLabel()));
        it.instructions.forEach(inst->inst.accept(this));
        currentFunc.blocks.add(currentBlock);
        return null;
    }

    @Override
    public Object visit(allocaInst it){
        int size=((IRPointerType)it.target.type).baseType.size()*it.number;
        int allocaAddr=currentFunc.stackManager.alloca(size);
        ASMReg reg=transIROperand(it.target);
        currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,reg,new Immediate(allocaAddr)));
        return null;
    }

    @Override
    public Object visit(binaryInst it){
        ASMReg left=transIROperand(it.leftOperand);
        ASMReg right=transIROperand(it.rightOperand);
        ASMReg target= transIROperand(it.target);
        switch (it.type){
            case mul -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.mul,target,left,right));
            case sdiv -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.sdiv,target,left,right));
            case srem -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.srem,target,left,right));
            case add -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,target,left,right));
            case sub -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.sub,target,left,right));
            case shl -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.sll,target,left,right));
            case ashr -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.srl,target,left,right));
            case and -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.and,target,left,right));
            case xor -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.xor,target,left,right));
            case or -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.or,target,left,right));
        }
        return null;
    }

    @Override
    public Object visit(bitcastInst it){
        ASMReg target=transIROperand(it.target);
        ASMReg source=transIROperand(it.source);
        currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.mv,target,source,null));
        return null;
    }

    @Override
    public Object visit(brInst it){
        ASMReg cond=transIROperand(it.cond);
        ASMLabel trueLabel=new ASMLabel(currentFunc,it.trueLabel.getLabel());
        ASMLabel falseLabel=new ASMLabel(currentFunc,it.falseLabel.getLabel());
        currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.bnez,cond,trueLabel));
        currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.j,falseLabel));
        return null;
    }

    @Override
    public Object visit(callInst it){
        int sumSize=0;
        for(int i=0;i<it.argvs.size();i++){
            if(i<8){
                currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.mv,new PhysicalReg(10+i),transIROperand(it.argvs.get(i)),null));
            }else{
                currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sw,transIROperand(it.argvs.get(i)),stackHeaderReg,new FuncStackSize(it.toCall.funcName,sumSize,false)));
                sumSize+=it.argvs.get(i).type.size();
            }
        }
        currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.call,it.toCall.funcName));
        return null;
    }

    @Override
    public Object visit(compareInst it){
        ASMReg target=transIROperand(it.target);
        ASMReg left=transIROperand(it.leftOperand);
        ASMReg right=transIROperand(it.rightOperand);
        switch (it.type){
            case eq -> {
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.sub,target,left,right));
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.seqz,target,target,null));
            }
            case ne -> {
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.sub,target,left,right));
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.snez,target,target,null));
            }
            case sgt -> {
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.slt,target,left,right));
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.xori,target,target,new Immediate(1)));
            }
            case sge -> {
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.slt,target,left,right));
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.xori,target,target,new Immediate(1)));
                ASMReg equAns= currentFunc.getTmpReg();
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.sub,equAns,left,right));
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.seqz,equAns,equAns,null));
            }
            case slt -> currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.slt,target,left,right));
            case sle -> {
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.sub,target,left,right));
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.seqz,target,target,null));
                ASMReg sltAns= currentFunc.getTmpReg();
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.slt,sltAns,left,right));
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.or,target,target,sltAns));
            }
        }
        return null;
    }

    @Override
    public Object visit(getElementInst it){
        ASMReg target=transIROperand(it.target);
        ASMReg header=transIROperand(it.header);
        ASMReg index=transIROperand(it.index);
        if(((IRPointerType)it.header.type).baseType instanceof IRClassType){
            //gep class
            int id=((IntConstant)it.index).value;
            String className=((ClassType)((IRPointerType)it.header.type).baseType).name();
            int offset=oriModule.classes.get(className).queryOffset(id);
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,target,header,new Immediate(offset)));
        }else{
            //gep array
            Immediate size=new Immediate(((IRPointerType)it.header.type).baseType.size());
            currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.mul,target,index,size));
            ASMReg tmp= currentFunc.getTmpReg();
            currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,tmp,header,target));
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,target,tmp,new Immediate(0)));
        }
        return null;
    }

    @Override
    public Object visit(jumpInst it){
        ASMLabel target=new ASMLabel(currentFunc,it.target.getLabel());
        currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.j,target));
        return null;
    }

    @Override
    public Object visit(loadInst it){
        ASMReg target=transIROperand(it.target);
        ASMReg addr=transIROperand(it.source);
        currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,target,addr,new Immediate(0)));
        return null;
    }

    @Override
    public Object visit(retInst it){
        if(it.toRet!=null){
            ASMReg val=transIROperand(it.toRet);
            currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.mv,new PhysicalReg(10),val,null));
        }
        currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,new PhysicalReg(1),stackHeaderReg,new Immediate(currentFunc.callerAddr)));
        currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.addi,new PhysicalReg(2),new PhysicalReg(2),new FuncStackSize(currentFunc.funcName,0,true)));
        currentBlock.insts.add(new ASMRetInst());
        return null;
    }

    @Override
    public Object visit(storeInst it){
        ASMReg addr=transIROperand(it.target);
        ASMReg val=transIROperand(it.source);
        currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sw,val,addr,new Immediate(0)));
        return null;
    }
}
