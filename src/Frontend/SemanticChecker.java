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
import Util.position;
import Util.varEntity;

import java.util.Stack;

public class SemanticChecker implements ASTVisitor{

    private Scope currentScope;
    private globalScope gScope;
    private classType currentClass;
    private Stack<ASTNode> loop=new Stack<>();
    private boolean hasRet=false;
    private Type retType;

    public SemanticChecker(globalScope gScope){
        this.gScope=gScope;
        this.currentScope=gScope;
        this.currentClass=null;
        this.retType=null;
    }

    private void errorThrower(String msg,ASTNode node)throws semanticError{
        throw new semanticError("[SemanticChecker]"+msg, node.pos);
    }

    @Override
    public void visit(programNode it) {

        if(gScope.getFunc("main",false)==null)
            errorThrower("[program] find no main function",it);
        currentScope=gScope;
        it.programBlockList.forEach(item->item.accept(this));
    }

    @Override
    public void visit(funcBlockNode it) {

        retType=it.func.retType;
        hasRet=false;
        currentScope=it.func.scope;
        it.funcStatementLists.accept(this);
        currentScope=currentScope.parentScope;
        if(it.funcName.equals("main")){
            hasRet=true;
            if(it.func.retType.type!=Type.types.Int)
                errorThrower("[main function declare] main function ret is not int",it);
            if(it.paras.isEmpty())
                errorThrower("[main function declare] main function cannot have paras",it);
        }
        if((retType.type!=Type.types.Void)&&!hasRet)
            errorThrower("[function declare] function retType is not void but no return",it);
    }

    @Override
    public void visit(classBlockNode it) {

        classType cl=gScope.getType(it.className);
        if(cl==null)
            throw new compilerError("[SemanticChecker][class define] find no fit class in gScope",it.pos);
        currentClass=cl;
        currentScope=cl.scope;
        it.funcList.forEach(item->item.accept(this));
        currentClass=null;
        currentScope=currentScope.parentScope;
    }

    @Override
    public void visit(buildFuncBlockNode it) {

        if(it.funcName.equals(currentClass.className)){
            errorThrower("[constructor declare] funcName not fit className",it);
        }
        retType=null;
        hasRet=false;
        currentScope=it.func.scope;
        it.funcStatementLists.accept(this);
        currentScope=currentScope.parentScope;
    }

    @Override
    public void visit(singleVarBlockNode it) {

        it.var=new varEntity(it.VarName,gScope.generateType(it.type),currentScope==gScope);
        if(it.var.type.type== Type.types.Void)
            errorThrower("[single var declare] varType is void",it);
        if(it.expr!=null){
            it.expr.accept(this);
            if(it.expr.type!=it.var.type&&it.var.type.type!= Type.types.Null)
                errorThrower("[single var declare] varType and initExpr type is different",it);
        }
        currentScope.defineVar(it.VarName,it.var,it.pos);
    }

    @Override
    public void visit(varBlockNode it) {

        it.varList.forEach(item->item.accept(this));
    }

    @Override
    public void visit(statementBlockNode it) {

        if(!it.statementList.isEmpty()){
            currentScope=new Scope(currentScope);
            it.statementList.forEach(item->item.accept(this));
            currentScope=currentScope.parentScope;
        }
    }

    @Override
    public void visit(breakNode it) {

        if(loop.empty())
            errorThrower("[break statement] break need to in the loop",it);

    }

    @Override
    public void visit(continueNode it) {

        if(loop.empty())
            errorThrower("[continue statement] continue need to in the loop",it);
    }

    @Override
    public void visit(exprStatementNode it) {

        it.expr.accept(this);
    }

    @Override
    public void visit(forNode it) {

        if(it.finishExp!=null){
            it.finishExp.accept(this);
            if(it.finishExp.type.type!= Type.types.Bool)
                errorThrower("[for statement] finishExpr need to be bool",it);
        }
        if(it.initExp!=null)it.initExp.accept(this);
        if(it.stepExp!=null)it.stepExp.accept(this);
        currentScope=new Scope(currentScope);
        loop.push(it);
        it.runStatement.accept(this);
        loop.pop();
        currentScope=currentScope.parentScope;
    }

    @Override
    public void visit(ifNode it) {

        it.condition.accept(this);
        if(it.condition.type.type!= Type.types.Bool)
            errorThrower("[if statement] conditionExpr need to be bool",it);
        currentScope=new Scope(currentScope);
        it.trueStatement.accept(this);
        currentScope=currentScope.parentScope;
        if(it.falseStatement!=null){
            currentScope=new Scope(currentScope);
            it.falseStatement.accept(this);
            currentScope=currentScope.parentScope;
        }
    }

    @Override
    public void visit(retNode it) {

        hasRet=true;
        if(it.returnExp==null){
            if(!(retType==null||retType.type==Type.types.Void)){
                errorThrower("[func return] has return type but return nothing",it);
            }
        }else{
            it.returnExp.accept(this);
            if(retType==null)
                errorThrower("[func return] constructor cannot has return",it);
            if(it.returnExp.type.type!=retType.type&&it.returnExp.type.type!=Type.types.Null)
                errorThrower("[func return] return type error",it);
            if(it.returnExp.type.dim()!=retType.dim())
                errorThrower("[func return] return dim not fit",it);
        }
    }

    @Override
    public void visit(whileNode it) {

        if(it.finishExp!=null){
            it.finishExp.accept(this);
            if(it.finishExp.type.type!= Type.types.Bool)
                errorThrower("[while statement] finishExpr need to be bool",it);
        }
        currentScope=new Scope(currentScope);
        loop.push(it);
        it.runStatement.accept(this);
        loop.pop();
        currentScope=currentScope.parentScope;
    }

    @Override
    public void visit(emptyStatementNode it) {}

    @Override
    public void visit(binaryExprNode it) {
        //todo

    }

    @Override
    public void visit(unaryExprNode it) {
        //todo

    }

    @Override
    public void visit(newArrayExprNode it) {
        //todo

    }

    @Override
    public void visit(newInitObjectExprNode it) {
        //todo

    }

    @Override
    public void visit(newObjectExprNode it) {
        //todo

    }

    @Override
    public void visit(postfixExprNode it) {
        //todo

    }

    @Override
    public void visit(funcCallExprNode it) {
        //todo

    }

    @Override
    public void visit(assignExprNode it) {
        //todo

    }

    @Override
    public void visit(classMemberExprNode it) {
        //todo

    }

    @Override
    public void visit(arrayMemberExprNode it) {
        //todo

    }

    @Override
    public void visit(thisExprNode it) {
        //todo

    }

    @Override
    public void visit(intConstNode it) {
        //todo

    }

    @Override
    public void visit(boolConstNode it) {
        //todo

    }

    @Override
    public void visit(nullConstNode it) {
        //todo

    }

    @Override
    public void visit(stringConstNode it) {
        //todo

    }

    @Override
    public void visit(singleTypeNode it) {
        //todo

    }

    @Override
    public void visit(typeNode it) {
        //todo

    }

    @Override
    public void visit(varNode it) {
        //todo

    }

    @Override
    public void visit(funcNode it) {
        //todo

    }

    @Override
    public void visit(methodNode it) {
        //todo

    }

    @Override
    public void visit(lambdaExprNode it) {
        //todo

    }
}