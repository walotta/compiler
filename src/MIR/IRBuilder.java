package MIR;

import AST.*;
import MIR.Function;
import MIR.IRScope.IRScopeBase;
import MIR.IRScope.IRScopeFunc;
import MIR.IRtype.*;
import MIR.Module;
import MIR.Operand.Register;
import Util.error.compilerError;

import java.util.ArrayList;

public class IRBuilder implements ASTVisitor {
    private Module module;
    private IRScopeBase currentScope;

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

    public IRBuilder(){
        module=new Module();
        currentScope=null;
    }

    public Module run(programNode it){
        it.accept(this);
        return module;
    }

    @Override
    public void visit(programNode it){
        //todo
        it.programBlockList.forEach(item->{
            item.accept(this);
            if(item instanceof funcBlockNode){
                //todo funcDecl
                module.functions.put(((funcBlockNode)item).funcName,((funcBlockNode)item).funcIR);
            }else if(item instanceof varBlockNode){
                //todo varDecl

            }else if(item instanceof classBlockNode){
                //todo classDecl
            }
        });

    }

    @Override
    public void visit(funcBlockNode it){
        //todo
        currentScope=new IRScopeFunc(currentScope);
        Function funcIR=new Function(it.funcName,transType(it.retType));
        for(int i=0;i<it.paras.size();i++){
            funcIR.paras.add(new Register(currentScope.regCnt(),it.paras.get(i).VarName,transType(it.paras.get(i).type)));
        }
        funcIR.buildInit((IRScopeFunc)currentScope);
        visit(it.funcStatementLists);
        funcIR.buildRet((IRScopeFunc)currentScope);
        it.funcIR=funcIR;
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
        //todo
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
        //todo
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
        //todo
    }
    
}
