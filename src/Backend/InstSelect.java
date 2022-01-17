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

import java.util.ArrayList;

public class InstSelect implements IRVisitor {
    private ASMModule asmModule;
    private int funcCnt=0;
    private ASMFunction currentFunc;
    private ASMBlock currentBlock;
    private final PhysicalReg stackHeaderReg=new PhysicalReg(2);
    private Module oriModule;
    private final int immMax=2047;
    private final PhysicalReg immOverFlowReg=new PhysicalReg(31);

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
            ASMReg ret=currentFunc.getTmpReg();
            currentBlock.insts.add(new ASMLaInst(ret,new ASMGloVar(((globalVariable) irOperand).identifier)));
            return ret;
        }else if(irOperand instanceof IntConstant){
            ASMReg ret=currentFunc.getTmpReg();
            currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,ret,new Immediate(((IntConstant)irOperand).value)));
            return ret;
        }else if(irOperand instanceof NullptrConstant){
            return new PhysicalReg(0);
        }else if(irOperand instanceof Register){
            return currentFunc.getReg((Register) irOperand);
        }else if(irOperand instanceof StringConstant){
            ASMReg ret=currentFunc.getTmpReg();
            currentBlock.insts.add(new ASMLaInst(ret,new ASMGloString(((StringConstant) irOperand).name,((StringConstant) irOperand).oriValue)));
            return ret;
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
        it.globalVars.forEach((varName,v)->{
            asmModule.globalVars.put(varName,new ASMGloVar(varName));
        });
        it.stringConstTable.forEach((stringName,st)->{
            asmModule.globalVars.put(stringName,new ASMGloString(st.name,st.oriValue));
        });
        it.functions.forEach((funcName,irFunc)->{
            if(!irFunc.isBuiltin){
                ASMFunction genFunc=(ASMFunction) irFunc.accept(this);
                asmModule.funcs.put(funcName,genFunc);
            }
        });
        it.classes.forEach((className,classU)->{
            if(classU.initFunc!=null){
                ASMFunction genFunc=(ASMFunction) classU.initFunc.accept(this);
                asmModule.funcs.put(genFunc.funcName,genFunc);
            }
            classU.methods.forEach((methodName,method)->{
                ASMFunction genFunc=(ASMFunction) method.accept(this);
                asmModule.funcs.put(genFunc.funcName,genFunc);
            });
        });
        if(it.initFuncs.size()>1) {
            ArrayList<ASMFunction> initFuncs=new ArrayList<>();
            it.initFuncs.forEach(func -> {
                if(!func.funcName.equals("_GLOBAL_INIT")) {
                    ASMFunction genFunc = (ASMFunction) func.accept(this);
                    asmModule.funcs.put(genFunc.funcName, genFunc);
                    initFuncs.add(genFunc);
                }
            });
            ASMBlock callInitFuncBlock = new ASMBlock(new ASMLabel(asmModule.funcs.get("main"), "callGlobalInit"));
            initFuncs.forEach(func->{
                callInitFuncBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.call,func.funcName));
            });
            asmModule.funcs.get("main").blocks.add(1,callInitFuncBlock);
        }

        return null;
    }

    @Override
    public Object visit(Function it){
        currentFunc=new ASMFunction(it.funcName,getFuncCnt());
        ASMBlock loadParasBlock=new ASMBlock(new ASMLabel(currentFunc,"FuncInit"));
        loadParasBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,immOverFlowReg,new FuncStackSize(currentFunc.funcName,0,false)));
        loadParasBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,stackHeaderReg,stackHeaderReg,immOverFlowReg));
        //define or load paras
        for(int i=0;i<it.paras.size();i++){
            if(i<8){
                //x10-x17
//                currentFunc.defineReg(it.paras.get(i),new PhysicalReg(10+i));
                ASMReg argv=transIROperand(it.paras.get(i));
                loadParasBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.mv,argv,new PhysicalReg(i+10),null));
            }else{
                currentFunc.stackManager.alloca(4);
                ASMReg vR=transIROperand(it.paras.get(i));
                if(4*i>immMax){
                    loadParasBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,immOverFlowReg,new Immediate(4*i)));
                    loadParasBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,immOverFlowReg,immOverFlowReg,stackHeaderReg));
                    loadParasBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,vR,immOverFlowReg,new Immediate(0)));
                }else{
                    loadParasBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,vR,stackHeaderReg,new Immediate(4*i)));
                }
            }
        }
        int callerAddr=currentFunc.stackManager.alloca(4);
        currentFunc.callerAddr=callerAddr;
        if(callerAddr>immMax){
            loadParasBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,immOverFlowReg,new Immediate(callerAddr)));
            loadParasBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,immOverFlowReg,immOverFlowReg,stackHeaderReg));
            loadParasBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sw,new PhysicalReg(1),immOverFlowReg,new Immediate(0)));
        }else{
            loadParasBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sw,new PhysicalReg(1),stackHeaderReg,new Immediate(callerAddr)));
        }
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
        if(allocaAddr>immMax){
            currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,immOverFlowReg,new Immediate(allocaAddr)));
            currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,reg,stackHeaderReg,immOverFlowReg));
        }else{
            currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.addi,reg,stackHeaderReg,new Immediate(allocaAddr)));
        }
        return null;
    }

    @Override
    public Object visit(binaryInst it){
        ASMReg left=transIROperand(it.leftOperand);
        ASMReg right=transIROperand(it.rightOperand);
        ASMReg target= transIROperand(it.target);
        switch (it.type){
            case mul -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.mul,target,left,right));
            case sdiv -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.div,target,left,right));
            case srem -> currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.rem,target,left,right));
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
                currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,immOverFlowReg,new FuncStackSize(it.toCall.funcName,sumSize,false)));
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,immOverFlowReg,immOverFlowReg,stackHeaderReg));
                currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sw,transIROperand(it.argvs.get(i)),immOverFlowReg,new Immediate(0)));
                sumSize+=it.argvs.get(i).type.size();
            }
        }
        currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.call,it.toCall.funcName));
        if(it.retReg!=null) {
            ASMReg retReg = transIROperand(it.retReg);
            currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.mv, retReg, new PhysicalReg(10), null));
        }
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
                ASMReg equAns= currentFunc.getTmpReg();
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.sub,equAns,left,right));
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.snez,equAns,equAns,null));
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.and,target,target,equAns));
            }
            case sge -> {
                currentBlock.insts.add(new ASMCompareInst(ASMCompareInst.op.slt,target,left,right));
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.xori,target,target,new Immediate(1)));
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
            String className=((IRClassType)((IRPointerType)it.header.type).baseType).name;
            int offset=oriModule.classes.get(className).queryOffset(id);
//            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,target,header,new Immediate(offset),it.toString()));
            if(offset>immMax){
                currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,immOverFlowReg,new Immediate(offset)));
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,target,header,immOverFlowReg,it.toString()));
            }else{
                currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.addi,target,header,new Immediate(offset),it.toString()));
            }
        }else{
            //gep array
            Immediate size=new Immediate(((IRPointerType)it.header.type).baseType.size());
            ASMReg sizeReg=currentFunc.getTmpReg();
            currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,sizeReg,size));
            currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.mul,target,index,sizeReg));
//            ASMReg tmp= currentFunc.getTmpReg();
//            currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,tmp,header,target));
//            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,target,tmp,new Immediate(0),it.toString()));
            currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,target,header,target,it.toString()));
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
        if(it.target.type.size()==1)
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lb,target,addr,new Immediate(0),it.toString()));
        else
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,target,addr,new Immediate(0),it.toString()));
        return null;
    }

    @Override
    public Object visit(retInst it){
        if(it.toRet!=null){
            ASMReg val=transIROperand(it.toRet);
            currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.mv,new PhysicalReg(10),val,null));
        }
        if(currentFunc.callerAddr>immMax){
            currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,immOverFlowReg,new Immediate(currentFunc.callerAddr)));
            currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,immOverFlowReg,immOverFlowReg,stackHeaderReg));
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,new PhysicalReg(1),immOverFlowReg,new Immediate(0)));
        }else{
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,new PhysicalReg(1),stackHeaderReg,new Immediate(currentFunc.callerAddr)));
        }
        currentBlock.insts.add(new ASMFakeInst(ASMFakeInst.op.li,immOverFlowReg,new FuncStackSize(currentFunc.funcName,0,true)));
        currentBlock.insts.add(new ASMCalInst(ASMCalInst.op.add,new PhysicalReg(2),new PhysicalReg(2),immOverFlowReg));
        currentBlock.insts.add(new ASMRetInst());
        return null;
    }

    @Override
    public Object visit(storeInst it){
        ASMReg addr=transIROperand(it.target);
        ASMReg val=transIROperand(it.source);
        if(it.source.type.size()==1)
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sb,val,addr,new Immediate(0),it.toString()));
        else
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sw,val,addr,new Immediate(0),it.toString()));
        return null;
    }
}
