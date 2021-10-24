package Frontend;

import AST.*;
import Util.Scope.Scope;
import Util.Scope.globalScope;
import Util.Type.Type;
import Util.Type.arrayType;
import Util.Type.classType;
import Util.Type.funcType;
import Util.error.compilerError;
import Util.error.semanticError;
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
            if(!it.paras.isEmpty())
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
            if(it.expr.type.type!=it.var.type.type&&it.var.type.type!= Type.types.Null)
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

        it.leftExp.accept(this);
        it.rightExp.accept(this);
        switch (it.op){
            case sub,mul,div,mod,bitLeft,bitRight,bitAnd,bitOr,bitXor->{
                if(it.leftExp.type.type!= Type.types.Int)
                    errorThrower("[binaryExpr left] type is not Int",it.leftExp);
                if(it.rightExp.type.type!= Type.types.Int)
                    errorThrower("[binaryExpr right] type is not Int",it.rightExp);
                it.type=it.leftExp.type;
            }
            case add->{
                if(it.leftExp.type.type!= Type.types.Int&&it.leftExp.type.type!= Type.types.String)
                    errorThrower("[binaryExpr left] add can only cal int and string",it.leftExp);
                if(it.rightExp.type.type!= Type.types.Int&&it.rightExp.type.type!= Type.types.String)
                    errorThrower("[binaryExpr right] add can only cal int and string",it.rightExp);
                if(it.rightExp.type.type!=it.leftExp.type.type)
                    errorThrower("[binaryExpr] leftExpr type and rightExpr type is not fit",it);
                it.type=it.leftExp.type;
            }
            case smallThan,smallEqual,bigEqual,bigThan->{
                if(it.leftExp.type.type!= Type.types.Int&&it.leftExp.type.type!= Type.types.String)
                    errorThrower("[binaryExpr left] add can only cal int and string",it.leftExp);
                if(it.rightExp.type.type!= Type.types.Int&&it.rightExp.type.type!= Type.types.String)
                    errorThrower("[binaryExpr right] add can only cal int and string",it.rightExp);
                if(it.rightExp.type.type!=it.leftExp.type.type)
                    errorThrower("[binaryExpr] leftExpr type and rightExpr type is not fit",it);
                it.type=gScope.getType("bool");
            }
            case isEqual,isNotEqual -> {
                boolean nullJudge=it.rightExp.type.type== Type.types.Null||it.leftExp.type.type== Type.types.Null;
                if(!nullJudge){
                    if(it.leftExp.type.type!= Type.types.Int&&it.leftExp.type.type!= Type.types.String&&it.leftExp.type.type!= Type.types.Bool)
                        errorThrower("[binaryExpr left] add can only cal int, bool and string",it.leftExp);
                    if(it.rightExp.type.type!= Type.types.Int&&it.rightExp.type.type!= Type.types.String&&it.rightExp.type.type!= Type.types.Bool)
                        errorThrower("[binaryExpr right] add can only cal int, bool and string",it.rightExp);
                    if(it.rightExp.type.type!=it.leftExp.type.type)
                        errorThrower("[binaryExpr] leftExpr type and rightExpr type is not fit",it);
                }
                it.type=gScope.getType("bool");
            }
            case logicAnd,logicOr -> {
                if(it.leftExp.type.type!= Type.types.Int&&it.leftExp.type.type!= Type.types.Bool)
                    errorThrower("[binaryExpr left] add can only cal int and bool",it.leftExp);
                if(it.rightExp.type.type!= Type.types.Int&&it.rightExp.type.type!= Type.types.Bool)
                    errorThrower("[binaryExpr right] add can only cal int and bool",it.rightExp);
                if(it.rightExp.type.type!=it.leftExp.type.type)
                    errorThrower("[binaryExpr] leftExpr type and rightExpr type is not fit",it);
                it.type=gScope.getType("bool");
            }
        }

    }

    @Override
    public void visit(unaryExprNode it) {

        it.calExp.accept(this);
        switch(it.op){
            case positive,negative,bitNot->{
                if(it.calExp.type.type!= Type.types.Int)
                    errorThrower("[unaryExpr] type is not Int",it);
                it.type=it.calExp.type;
            }
            case selfAdd,selfSub->{
                if(it.calExp.type.type!= Type.types.Int)
                    errorThrower("[unaryExpr] type is not Int",it);
                if(!it.calExp.isAssignable)
                    errorThrower("[unaryExpr] var is not assignable",it);
                it.type=it.calExp.type;
            }
            case logicNot -> {
                if(it.calExp.type.type!= Type.types.Bool)
                    errorThrower("[unaryExpr] type is not Bool",it);
                it.type=it.calExp.type;
            }
        }
    }

    @Override
    public void visit(newArrayExprNode it) {

        it.ExprList.forEach(item->{
            item.accept(this);
            if(item.type.type!= Type.types.Int)
                errorThrower("[new array] index is not Int",it);
        });
        it.type=gScope.generateType(it.arrayType);
    }

    @Override
    public void visit(newInitObjectExprNode it) {

        it.exprList.forEach(item->item.accept(this));
        it.type=gScope.generateType(it.objectType);
    }

    @Override
    public void visit(newObjectExprNode it) {

        it.type=gScope.generateType(it.objectType);
    }

    @Override
    public void visit(postfixExprNode it) {

        it.calExp.accept(this);
        if(it.calExp.type.type!= Type.types.Int)
            errorThrower("[unaryExpr] type is not Int",it);
        if(!it.calExp.isAssignable)
            errorThrower("[unaryExpr] var is not assignable",it);
        it.type=it.calExp.type;
    }

    @Override
    public void visit(funcCallExprNode it) {

        it.funcName.accept(this);
        if(!(it.funcName.type instanceof funcType))
            errorThrower("[func call] be called is not function",it);
        if(!it.paras.isEmpty())
            it.paras.forEach(item->item.accept(this));
        funcType func=(funcType) it.funcName.type;
        if(func.scope.paras.size()!=it.paras.size())
            errorThrower("[func call] paras size not fit",it);
        for(int i=0;i<it.paras.size();i++){
            if(it.paras.get(i).type.type== Type.types.Null)continue;
            if(it.paras.get(i).type.type!=func.scope.paras.get(i).type.type)
                errorThrower("[func call] paras type not fit",it);
            if(it.paras.get(i).type.dim()!=func.scope.paras.get(i).type.dim())
                errorThrower("[func call] paras dim not fit",it);
        }
        it.type=func.retType;
    }

    @Override
    public void visit(assignExprNode it) {

        it.rightExpr.accept(this);
        it.leftExpr.accept(this);
        if(it.rightExpr.type.type!= Type.types.Null){
            if(it.rightExpr.type.type!=it.leftExpr.type.type)
                errorThrower("[assignExpr] type not fit",it);
            if(it.leftExpr.type.dim()!=it.rightExpr.type.dim())
                errorThrower("[assignExpr] dim not fit",it);
            if(!it.leftExpr.isAssignable)
                errorThrower("[assignExpr] leftExpr is not assignable",it);
        }else if(it.leftExpr.type.type== Type.types.Int||it.leftExpr.type.type== Type.types.Bool){
            errorThrower("[assignExpr] int and bool cannot be null",it);
        }
        it.type=it.rightExpr.type;
    }

    @Override
    public void visit(classMemberExprNode it) {

        it.fatherExpr.accept(this);
        if(it.fatherExpr.type.type!= Type.types.Class)
            errorThrower("[member access] not a class",it);
        classType cl=(classType) it.fatherExpr.type;
        if(cl.scope.getVar(it.memberName,false)==null)
            errorThrower("[member access] member not find",it);
        else{
            it.var=cl.scope.getVar(it.memberName,false);
            it.type=it.var.type;
        }
    }

    @Override
    public void visit(arrayMemberExprNode it) {

        it.arrayFather.accept(this);
        it.index.accept(this);
        if(it.index.type.type!= Type.types.Int)
            errorThrower("[array member] index is not Int",it.index);
        if(it.arrayFather.type.dim()>1)
            it.type=new arrayType(((arrayType)it.arrayFather.type).arrayType,(it.arrayFather.type).dim()-1);
        else if(it.arrayFather.type.dim()<1)
            errorThrower("[array member] not a array",it.arrayFather);
        else
            it.type=((arrayType)it.arrayFather.type).arrayType;
    }

    @Override
    public void visit(thisExprNode it) {

        if(currentClass==null)
            errorThrower("[thisExpr] called not in class",it);
        it.type=currentClass;
    }

    @Override
    public void visit(intConstNode it) {

        it.type=gScope.getType("int");
    }

    @Override
    public void visit(boolConstNode it) {

        it.type=gScope.getType("bool");
    }

    @Override
    public void visit(nullConstNode it) {

        it.type=gScope.getType("null");
    }

    @Override
    public void visit(stringConstNode it) {

        it.type=gScope.getType("string");
    }

    @Override
    public void visit(singleTypeNode it) {}

    @Override
    public void visit(typeNode it) {}

    @Override
    public void visit(varNode it) {

        it.var=currentScope.getVar(it.name,true);
        it.type=it.var.type;
    }

    @Override
    public void visit(funcNode it) {

        it.type=currentScope.getFunc(it.funcName,true);
    }

    @Override
    public void visit(methodNode it) {

        it.father.accept(this);
        if(it.father.type.type== Type.types.Array){
            if(!it.methodName.equals("size"))
                errorThrower("[method] array call func but not size",it.father);
            else it.type=gScope.getFunc("size",false);
        }else{
            if(it.father.type.type!= Type.types.Class&&it.father.type.type!= Type.types.String)
                errorThrower("[method] call method but not class or string",it.father);
            funcType func=((classType) it.father.type).scope.getFunc(it.methodName,false);
            if(func==null)
                errorThrower("[method] match no method",it);
            else it.type=func;
        }
    }

    @Override
    public void visit(lambdaExprNode it) {
        //todo

    }
}