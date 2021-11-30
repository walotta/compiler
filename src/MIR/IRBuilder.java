package MIR;

import AST.*;
import MIR.Function;
import MIR.IRInstruction.callInst;
import MIR.IRInstruction.jumpInst;
import MIR.IRScope.IRScopeBase;
import MIR.IRScope.IRScopeFunc;
import MIR.IRtype.*;
import MIR.Module;
import MIR.Operand.IROperand;
import MIR.Operand.IntConstant;
import MIR.Operand.Label;
import MIR.Operand.Register;
import Util.Scope.globalScope;
import Util.Type.Type;
import Util.Type.arrayType;
import Util.Type.classType;
import Util.Type.funcType;
import Util.error.compilerError;
import Util.position;

import java.util.ArrayList;

public class IRBuilder implements ASTVisitor {
    private Module module;
    private IRScopeBase currentScope;
    private BasicBlock currentBlock;
    private Function currentFunc;
    private IROperand calBack;

    private IRBaseType transType(typeNode t){
        //todo class
        String typeName=t.typeName;
        IRBaseType irType;
        if(t.dim==0){
            switch (typeName){
                case "int"->{irType=new IRIntType();}
                case "bool"->{irType=new IRBoolType();}
                case "string"->{irType=new IRStringType();}
                case "void"->{irType=new IRVoidType();}
                default -> {throw new compilerError("class type trans",t.pos);}
            }
        }else{
            irType=new IRPointerType(transType(new typeNode(t.pos,t.typeName,t.dim-1)));
        }
        return irType;
    }

    public IRBuilder(globalScope gScope){
        module=new Module(gScope);
        currentScope=null;
        calBack=null;
    }

    public Module run(programNode it){
        it.accept(this);
        return module;
    }

    @Override
    public void visit(programNode it){
        it.programBlockList.forEach(item->{
            item.accept(this);
        });

    }

    @Override
    public void visit(funcBlockNode it){
        currentScope=new IRScopeFunc(currentScope);
        currentFunc=module.functions.get(it.funcName);
        for(int i=0;i<it.paras.size();i++){
            currentFunc.paras.add(new Register(currentScope.regCnt(),it.paras.get(i).VarName,transType(it.paras.get(i).type)));
        }
        currentBlock=new BasicBlock(new Label(currentScope.regCnt()));
        currentFunc.buildInit((IRScopeFunc)currentScope,currentBlock);
        visit(it.funcStatementLists);
        currentBlock.instructions.add(currentFunc.jumpToRet());
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
        //todo
    }

    @Override
    public void visit(varBlockNode it){
        //todo
    }

    @Override
    public void visit(statementBlockNode it){
        currentScope=new IRScopeBase(currentScope);

        it.statementList.forEach(item->item.accept(this));

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
        //todo
    }

    @Override
    public void visit(retNode it){
        //todo
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
        currentBlock.instructions.add(inst);
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
        //todo
        calBack=new IntConstant(it.value);
    }

    @Override
    public void visit(boolConstNode it){
        //todo
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
        //todo
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
