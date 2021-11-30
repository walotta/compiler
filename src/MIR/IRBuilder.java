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
    private LabelCounter labelCounter;
    private final TransTypeToIR trans=new TransTypeToIR();

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
        it.varList.forEach(v->{
            v.accept(this);
        });
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
        //todo
        IRBaseType irType=trans.transType(it.type);
        switch (it.op){
            case mul -> {

            }
            case div -> {

            }
            case mod -> {

            }
            case add -> {

            }
            case sub -> {

            }
            case bitLeft -> {

            }
            case bitRight -> {

            }
            case smallThan -> {

            }
            case bigThan -> {

            }
            case smallEqual -> {

            }
            case bigEqual -> {

            }
            case isEqual -> {

            }
            case isNotEqual -> {

            }
            case bitAnd -> {

            }
            case bitXor -> {

            }
            case bitOr -> {

            }
            case logicAnd -> {

            }
            case logicOr -> {

            }
        }
    }

    @Override
    public void visit(unaryExprNode it){
        //todo
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
    }

    @Override
    public void visit(classMemberExprNode it){
        //todo
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
        //todo
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
        calBack=new Register(currentScope.regCnt(),null,((IRPointerType)Addr.type).baseType);
        currentBlock.pushInstruction(new loadInst((Register) calBack,Addr));
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
