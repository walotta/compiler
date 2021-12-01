package MIR;

import AST.*;
import MIR.Function;
import MIR.IRInstruction.*;
import MIR.IRScope.IRScopeBase;
import MIR.IRScope.IRScopeFunc;
import MIR.IRScope.IRScopeGlobal;
import MIR.IRtype.*;
import MIR.Module;
import MIR.Operand.*;
import Util.Scope.globalScope;
import Util.Type.Type;
import Util.Type.arrayType;
import Util.Type.classType;
import Util.Type.funcType;
import Util.error.compilerError;
import Util.position;

import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

public class IRBuilder implements ASTVisitor {
    private Module module;
    private IRScopeBase currentScope;
    private BasicBlock currentBlock;
    private Function currentFunc;
    private IROperand calBack;
    private final LabelCounter labelCounter;
    private final TransTypeToIR trans=new TransTypeToIR();
    private final position throwPos=new position(0,0);
    private boolean getLeftPointer=false;

    public IRBuilder(globalScope gScope){
        module=new Module(gScope);
        currentScope=null;
        calBack=null;
        labelCounter=new LabelCounter();
    }

    public Module run(programNode it){
        it.accept(this);
        return module;
    }

    @Override
    public void visit(programNode it){
        currentScope=new IRScopeGlobal(currentScope);
        ((IRScopeGlobal)currentScope).insertGlobalVar();
        it.programBlockList.forEach(item->{
            if(item instanceof funcBlockNode || item instanceof classBlockNode)
            item.accept(this);
        });
    }

    @Override
    public void visit(funcBlockNode it){
        currentScope=new IRScopeFunc(currentScope);
        currentFunc=module.functions.get(it.funcName);
        for(int i=0;i<it.paras.size();i++){
            currentFunc.paras.add(new Register(currentScope.regCnt(),it.paras.get(i).VarName,trans.transType(it.paras.get(i).type)));
        }
        currentBlock=new BasicBlock(new Label(currentScope.regCnt()));
        currentFunc.buildInit((IRScopeFunc)currentScope,currentBlock);
        visit(it.funcStatementLists);
        if(currentBlock.canInsert())
            currentBlock.pushInstruction(currentFunc.jumpToRet());
        currentFunc.Blocks.add(currentBlock);
        currentBlock=currentFunc.genRetBlock(currentScope);
        currentFunc.Blocks.add(currentBlock);
        module.functions.put(it.funcName,currentFunc);
        currentBlock=null;
        currentFunc=null;
        currentScope=currentScope.parentsScope;
    }

    @Override
    public void visit(classBlockNode it){
        //todo
    }

    @Override
    public void visit(buildFuncBlockNode it){
        //todo
    }

    @Override
    public void visit(singleVarBlockNode it){
        if(it.expr==null)
            calBack=null;
        else
            it.expr.accept(this);
        IRBaseType irType=trans.transType(it.type);
        Register reg=new Register(currentScope.regCnt(),it.VarName,new IRPointerType(irType));
        currentScope.renameTable.put(it.VarName,reg);
        currentBlock.pushInstruction(new allocaInst(reg));
        if(calBack==null)
            currentBlock.pushInstruction(new storeInst(irType.defaultValue(),reg));
        else
            currentBlock.pushInstruction(new storeInst(calBack,reg));
    }

    @Override
    public void visit(varBlockNode it){
        it.varList.forEach(v->
                v.accept(this));
    }

    @Override
    public void visit(statementBlockNode it){
        currentScope=new IRScopeBase(currentScope);

        it.statementList.forEach(item-> {
            if(currentBlock.canInsert())
                item.accept(this);
        });

        currentScope.parentsScope.copyCnt(currentScope);
        currentScope=currentScope.parentsScope;
    }

    @Override
    public void visit(breakNode it){
        //todo
    }

    @Override
    public void visit(continueNode it){
        //todo
    }

    @Override
    public void visit(exprStatementNode it){
        //todo
        it.expr.accept(this);
    }

    @Override
    public void visit(forNode it){
        //todo
    }

    @Override
    public void visit(ifNode it){
        it.condition.accept(this);
        int ifId=labelCounter.getCnt();
        Label trueLabel=new Label("ifTrueBlock."+ifId);
        Label finalLabel=new Label("ifNextBlock."+ifId);
        Label falseLabel=finalLabel;
        if(it.falseStatement!=null){
            falseLabel=new Label("ifFalseBlock."+ifId);
        }
        currentBlock.pushInstruction(new brInst(calBack,trueLabel,falseLabel));
        currentFunc.Blocks.add(currentBlock);

        //gen True Block
        currentBlock=new BasicBlock(trueLabel);
        currentScope=new IRScopeBase(currentScope);
        it.trueStatement.accept(this);
        currentScope.parentsScope.copyCnt(currentScope);
        currentScope=currentScope.parentsScope;
        if(currentBlock.canInsert())
            currentBlock.pushInstruction(new jumpInst(finalLabel));
        currentFunc.Blocks.add(currentBlock);

        //gen False Block
        if(it.falseStatement!=null){
            currentBlock=new BasicBlock(falseLabel);
            currentScope=new IRScopeBase(currentScope);
            it.falseStatement.accept(this);
            if(currentBlock.canInsert())
                currentBlock.pushInstruction(new jumpInst(finalLabel));
            currentFunc.Blocks.add(currentBlock);
            currentScope.parentsScope.copyCnt(currentScope);
            currentScope=currentScope.parentsScope;
        }

        //gen Next Block
        currentBlock=new BasicBlock(finalLabel);
    }

    @Override
    public void visit(retNode it){
        it.returnExp.accept(this);
        currentBlock.pushInstruction(new storeInst(calBack,currentFunc.retReg));
        currentBlock.pushInstruction(currentFunc.jumpToRet());
    }

    @Override
    public void visit(whileNode it){
        //todo
    }

    @Override
    public void visit(emptyStatementNode it){
        //todo
    }

    @Override
    public void visit(binaryExprNode it){
        IRBaseType irType=trans.transType(it.type);
        IRBaseType calType=trans.transType(it.leftExp.type);
        IROperand left,right;
        it.leftExp.accept(this);
        left=calBack;
        it.rightExp.accept(this);
        right=calBack;
        Instruction inst;
        Register target=new Register(currentScope.regCnt(),null,irType);
        if(calType instanceof IRIntType){
            switch (it.op){
                case mul -> inst=new binaryInst(binaryInst.binaryType.mul,left,right,target);
                case div -> inst=new binaryInst(binaryInst.binaryType.sdiv,left,right,target);
                case mod -> inst=new binaryInst(binaryInst.binaryType.srem,left,right,target);
                case add -> inst=new binaryInst(binaryInst.binaryType.add,left,right,target);
                case sub -> inst=new binaryInst(binaryInst.binaryType.sub,left,right,target);
                case bitLeft -> inst=new binaryInst(binaryInst.binaryType.shl,left,right,target);
                case bitRight -> inst=new binaryInst(binaryInst.binaryType.ashr,left,right,target);
                case smallThan -> inst=new compareInst(compareInst.compareType.slt,left,right,target);
                case bigThan -> inst=new compareInst(compareInst.compareType.sgt,left,right,target);
                case smallEqual -> inst=new compareInst(compareInst.compareType.sle,left,right,target);
                case bigEqual -> inst=new compareInst(compareInst.compareType.sge,left,right,target);
                case isEqual -> inst=new compareInst(compareInst.compareType.eq,left,right,target);
                case isNotEqual -> inst=new compareInst(compareInst.compareType.ne,left,right,target);
                case bitAnd -> inst=new binaryInst(binaryInst.binaryType.and,left,right,target);
                case bitXor -> inst=new binaryInst(binaryInst.binaryType.xor,left,right,target);
                case bitOr -> inst=new binaryInst(binaryInst.binaryType.or,left,right,target);
                default -> throw new compilerError("forbidden binary for int",throwPos);
            }
        }else if(calType instanceof IRBoolType){
            switch (it.op){
                case isEqual -> inst=new compareInst(compareInst.compareType.eq,left,right,target);
                case isNotEqual -> inst=new compareInst(compareInst.compareType.ne,left,right,target);
                case bitAnd -> inst=new binaryInst(binaryInst.binaryType.and,left,right,target);
                case bitXor -> inst=new binaryInst(binaryInst.binaryType.xor,left,right,target);
                case bitOr -> inst=new binaryInst(binaryInst.binaryType.or,left,right,target);
                case logicAnd -> throw new compilerError("logicAnd todo",throwPos);
                case logicOr -> throw new compilerError("logicOr todo",throwPos);
                default -> throw new compilerError("forbidden binary for bool",throwPos);
            }
        }else if(calType instanceof IRStringType){
            //todo
            throw new compilerError("binary String todo",throwPos);
        }else if(calType instanceof IRClassType){
            //todo
            throw new compilerError("binary Class todo",throwPos);
        }else{
            throw new compilerError("binary for forbidden type",throwPos);
        }
        calBack=target;
        currentBlock.pushInstruction(inst);
    }

    @Override
    public void visit(unaryExprNode it){
        Register source;
        IROperand val;
        boolean queryLeft=getLeftPointer;
        if(it.op== unaryExprNode.opType.selfAdd || it.op== unaryExprNode.opType.selfSub){
            getLeftPointer=true;
            it.calExp.accept(this);
            getLeftPointer=queryLeft;
            source=(Register) calBack;
            val=new Register(currentScope.regCnt(),null,trans.transType(it.type));
            currentBlock.pushInstruction(new loadInst((Register) val,source));
        }else{
            getLeftPointer=false;
            it.calExp.accept(this);
            getLeftPointer=queryLeft;
            source=null;
            val=calBack;
        }
        switch (it.op){
            case selfAdd -> {
                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.add,val,new IntConstant(1),ans));
                currentBlock.pushInstruction(new storeInst(ans,source));
                if(getLeftPointer)
                    calBack=source;
                else
                    calBack=ans;
            }
            case selfSub -> {
                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.sub,val,new IntConstant(1),ans));
                currentBlock.pushInstruction(new storeInst(ans,source));
                if(getLeftPointer)
                    calBack=source;
                else
                    calBack=ans;
            }
            case positive -> {
                if(getLeftPointer)
                    throw new compilerError("+ operation return no left value",throwPos);
                calBack=val;
            }
            case negative -> {
                if(getLeftPointer)
                    throw new compilerError("- operation return no left value",throwPos);

                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.sub,new IntConstant(0),val,ans));
                calBack=ans;
            }
            case logicNot -> {
                if(getLeftPointer)
                    throw new compilerError("! operation return no left value",throwPos);

                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.xor,new BoolConstant(true),val,ans));
                calBack=ans;
            }
            case bitNot -> {
                if(getLeftPointer)
                    throw new compilerError("~ operation return no left value",throwPos);

                Register ans=new Register(currentScope.regCnt(),null,trans.transType(it.type));
                currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.xor,new IntConstant(-1),val,ans));
                calBack=ans;
            }
        }
    }

    @Override
    public void visit(newArrayExprNode it){
        //todo
    }

    @Override
    public void visit(newInitObjectExprNode it){
        //todo
    }

    @Override
    public void visit(newObjectExprNode it){
        //todo
    }

    @Override
    public void visit(postfixExprNode it){
        //todo
        boolean queryLeft=getLeftPointer;
        getLeftPointer=true;
        it.calExp.accept(this);
        getLeftPointer=queryLeft;
        Register source=(Register) calBack;
        calBack=new Register(currentScope.regCnt(),null,trans.transType(it.type));
        currentBlock.pushInstruction(new loadInst((Register) calBack,source));

        Register tmp=new Register(currentScope.regCnt(),null,trans.transType(it.type));
        switch (it.op){
            case selfAdd -> currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.add,calBack,new IntConstant(1),tmp));
            case selfSub -> currentBlock.pushInstruction(new binaryInst(binaryInst.binaryType.sub,calBack,new IntConstant(1),tmp));
        }
        currentBlock.pushInstruction(new storeInst(tmp,source));
    }

    @Override
    public void visit(funcCallExprNode it){
        Function toCall=module.functions.get(((funcNode)it.funcName).funcName);
        Register retReg;
        ArrayList<IROperand> parasExp=new ArrayList<>();
        for(var para:it.paras){
            para.accept(this);
            parasExp.add(calBack);
        }
        if(toCall.retType instanceof IRVoidType)retReg=null;
        else{
            retReg=new Register(currentScope.regCnt(),null,toCall.retType);
        }
        callInst inst=new callInst(toCall,retReg,parasExp);
        currentBlock.pushInstruction(inst);
        calBack=retReg;
    }

    @Override
    public void visit(assignExprNode it){
        //todo
        Register left;
        IROperand right;
        boolean queryLeft=getLeftPointer;
        getLeftPointer=true;
        it.leftExpr.accept(this);
        getLeftPointer=queryLeft;
        left=(Register) calBack;
        it.rightExpr.accept(this);
        right=calBack;
        currentBlock.pushInstruction(new storeInst(right,left));
        calBack=left;
    }

    @Override
    public void visit(classMemberExprNode it){
        //todo care for left value access
    }

    @Override
    public void visit(arrayMemberExprNode it){
        //todo
    }

    @Override
    public void visit(thisExprNode it){
        //todo
    }

    @Override
    public void visit(intConstNode it){
        calBack=new IntConstant(it.value);
    }

    @Override
    public void visit(boolConstNode it){
        calBack=new BoolConstant(it.value);
    }

    @Override
    public void visit(nullConstNode it){
        calBack=new NullptrConstant(new IRPointerType(trans.transType(it.type)));
    }

    @Override
    public void visit(stringConstNode it){
        //todo
    }

    @Override
    public void visit(singleTypeNode it){
        //todo
    }

    @Override
    public void visit(typeNode it){
        //todo
    }

    @Override
    public void visit(varNode it){
        Register Addr=(Register) currentScope.queryRename(it.name);
        if(getLeftPointer){
            calBack=Addr;
        }else{
            calBack=new Register(currentScope.regCnt(),null,((IRPointerType)Addr.type).baseType);
            currentBlock.pushInstruction(new loadInst((Register) calBack,Addr));
        }
    }

    @Override
    public void visit(funcNode it){
        //todo
    }

    @Override
    public void visit(methodNode it){
        //todo
    }

    @Override
    public void visit(lambdaExprNode it){
        throw new compilerError("cannot deal with lambda!",it.pos);
    }

}
