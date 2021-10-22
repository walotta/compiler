package Frontend;

import AST.*;
import Util.Scope.Scope;
import Util.Scope.funcScope;
import Util.Scope.globalScope;
import Util.Type.Type;
import Util.Type.classType;
import Util.Type.funcType;
import Util.error.compilerError;
import Util.error.semanticError;
import Util.varEntity;

import java.util.zip.CRC32;

public class TypeFilter implements ASTVisitor {
    private globalScope gScope;
    private Scope currentScope = null;
    boolean collectClassMember=false;

    public TypeFilter(globalScope gScope) {
        this.gScope = gScope;
    }

    @Override
    public void visit(programNode it) {
        currentScope=gScope;
        it.programBlockList.forEach(item->{
            if(!(item instanceof varBlockNode))
                item.accept(this);
        });
    }

    @Override
    public void visit(funcBlockNode it) {
        funcType func=it.func;
        if(it.retType!=null){
            func.retType=gScope.generateType(it.retType);
        }else func.retType=null;
        currentScope=new funcScope(currentScope);
        it.paras.forEach(item->item.accept(this));
        func.scope=(funcScope) currentScope;
        currentScope=currentScope.parentScope;
    }

    @Override
    public void visit(classBlockNode it) {
        classType cl=gScope.getType(it.className);
        currentScope=cl.scope;
        it.funcList.forEach(item->item.accept(this));
        collectClassMember=true;
        it.varLists.forEach(item->item.accept(this));
        collectClassMember=false;
        currentScope=currentScope.parentScope;
    }

    @Override
    public void visit(singleVarBlockNode it) {
        varEntity v=new varEntity(it.VarName, gScope.generateType(it.type),false );
        if(collectClassMember){
            v.isMember=true;
            it.var=v;
            if(it.var.type.type== Type.types.Void)
                throw new semanticError("[typeFilter][class member var declare] varType is void",it.pos);
            if(it.expr!=null){
                it.expr.accept(this);
                if(it.expr.type!=it.var.type&&it.var.type.type!= Type.types.Null)
                    throw new semanticError("[typeFilter][class member var declare] varType and initExpr type is different",it.pos);
            }
            currentScope.defineVar(it.VarName,v,it.pos);
        }else{
            if(v.type.type== Type.types.Void)
                throw new semanticError("[typeFilter][paras declare] paras type can be void",it.pos);
            if(currentScope instanceof funcScope){
                it.var=v;
                ((funcScope)currentScope).addParas(v, it.pos);
            }else{
                throw new compilerError("[typeFilter][single variable declare] scope is not funcScope",it.pos);
            }
        }
    }

    @Override
    public void visit(varBlockNode it) {
        it.varList.forEach(item->item.accept(this));
    }

    @Override
    public void visit(statementBlockNode it) {}

    @Override
    public void visit(breakNode it) {}

    @Override
    public void visit(continueNode it) {}

    @Override
    public void visit(exprStatementNode it) {}

    @Override
    public void visit(forNode it) {}

    @Override
    public void visit(ifNode it) {}

    @Override
    public void visit(retNode it) {}

    @Override
    public void visit(whileNode it) {}

    @Override
    public void visit(emptyStatementNode it) {}

    @Override
    public void visit(binaryExprNode it) {}

    @Override
    public void visit(unaryExprNode it) {}

    @Override
    public void visit(newArrayExprNode it) {}

    @Override
    public void visit(newInitObjectExprNode it) {}

    @Override
    public void visit(newObjectExprNode it) {}

    @Override
    public void visit(postfixExprNode it) {}

    @Override
    public void visit(funcCallExprNode it) {}

    @Override
    public void visit(assignExprNode it) {}

    @Override
    public void visit(classMemberExprNode it) {}

    @Override
    public void visit(arrayMemberExprNode it) {}

    @Override
    public void visit(thisExprNode it) {}

    @Override
    public void visit(intConstNode it) {}

    @Override
    public void visit(boolConstNode it) {}

    @Override
    public void visit(nullConstNode it) {}

    @Override
    public void visit(stringConstNode it) {}

    @Override
    public void visit(singleTypeNode it) {}

    @Override
    public void visit(typeNode it) {}

    @Override
    public void visit(varNode it) {}

    @Override
    public void visit(funcNode it) {}

    @Override
    public void visit(methodNode it) {}

    @Override
    public void visit(lambdaExprNode it) {}

    @Override
    public void visit(buildFuncBlockNode it) {}

}
