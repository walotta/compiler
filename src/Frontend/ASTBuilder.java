package Frontend;

import AST.*;
import Parser.MxBaseVisitor;
import Parser.MxParser;
import Util.error.semanticError;
import Util.position;

import java.util.ArrayList;
public class ASTBuilder extends MxBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(MxParser.ProgramContext ctx){
        ArrayList<ASTNode> tmp=new ArrayList<ASTNode>();
        for (var item:ctx.programBlock()){
            tmp.add(visit(item));
        }
        return new programNode(new position(ctx), tmp);
    }

    @Override
    public ASTNode visitProgramBlock(MxParser.ProgramBlockContext ctx){
        if(ctx.classBlock()!=null){
            return visit(ctx.classBlock());
        }else if(ctx.funcBlock()!=null){
            return visit(ctx.funcBlock());
        }else if(ctx.varBlock()!=null){
            return visit(ctx.varBlock());
        }else{
            return null;
        }
    }

    @Override
    public ASTNode visitClassBlock(MxParser.ClassBlockContext ctx){

        String className;
        ArrayList<funcBlockNode> funcList=new ArrayList<funcBlockNode>();
        ArrayList<varBlockNode> varLists=new ArrayList<varBlockNode>();
        ArrayList<buildFuncBlockNode> buildFuncList=new ArrayList<buildFuncBlockNode>();

        className=ctx.Identifier().getText();
        for(var item:ctx.funcBlock()){
            funcList.add((funcBlockNode) visit(item));
        }
        for(var item:ctx.varBlock()){
            varLists.add((varBlockNode) visit(item));
        }
        for(var item:ctx.buildFuncBlock()){
            buildFuncList.add((buildFuncBlockNode) visit(item));
        }

        return new classBlockNode(new position(ctx),className,funcList,varLists,buildFuncList);
    }

    @Override
    public ASTNode visitBuildFuncBlock(MxParser.BuildFuncBlockContext ctx){
        String funcName=ctx.funcName.getText();
        ArrayList<singleVarBlockNode> paras=new ArrayList<singleVarBlockNode>();
        statementBlockNode funcStatementBlock;

        for(int i = 0; i < ctx.type().size(); i++){
            singleVarBlockNode tmp=new singleVarBlockNode(new position(ctx),ctx.Identifier(i+1).getText(),null);
            tmp.type=(typeNode) visit(ctx.type(i));
            paras.add(tmp);
        }

        funcStatementBlock=(statementBlockNode) visit(ctx.statementBlock());
        return new buildFuncBlockNode(new position(ctx),funcName,paras,funcStatementBlock);
    }

    @Override
    public ASTNode visitFuncBlock(MxParser.FuncBlockContext ctx){

        typeNode retType = null;
        if(ctx.retType()!=null){
            retType=(typeNode) visit(ctx.retType());
        }
        String funcName=ctx.funcName.getText();
        ArrayList<singleVarBlockNode> paras=new ArrayList<singleVarBlockNode>();
        statementBlockNode funcStatementBlock;

        for(int i = 0; i < ctx.type().size(); i++){
            singleVarBlockNode tmp=new singleVarBlockNode(new position(ctx),ctx.Identifier(i+1).getText(),null);
            tmp.type=(typeNode) visit(ctx.type(i));
            paras.add(tmp);
        }

        funcStatementBlock=(statementBlockNode) visit(ctx.statementBlock());
        return new funcBlockNode(new position(ctx),retType,funcName,paras,funcStatementBlock);
    }

    @Override
    public ASTNode visitRetType(MxParser.RetTypeContext ctx){

        if(ctx.Void()!=null)
            return new singleTypeNode(new position(ctx),"void");
        else return visit(ctx.type());
    }

    @Override
    public ASTNode visitVarBlock(MxParser.VarBlockContext ctx){
        typeNode type;
        ArrayList<singleVarBlockNode> varList=new ArrayList<singleVarBlockNode>();

        type=(typeNode) visit(ctx.type());
        for(var item:ctx.singleVarBlock()){
            singleVarBlockNode tmp=(singleVarBlockNode) visit(item);
            tmp.type=type;
            varList.add(tmp);
        }
        return new varBlockNode(new position(ctx),type,varList);
    }

    @Override
    public ASTNode visitSingleVarBlock(MxParser.SingleVarBlockContext ctx){

        String identifier;
        exprNode expr;

        identifier=ctx.Identifier().getText();
        if(ctx.experssion()!=null){
            expr=(exprNode) visit(ctx.experssion());
        }else{
            expr=null;
        }

        return new singleVarBlockNode(new position(ctx),identifier,expr);
    }

    @Override
    public ASTNode visitType(MxParser.TypeContext ctx){

        int dim;
        if(ctx.LeftBracket()!=null){
            dim=ctx.LeftBracket().size();
        }else{
            dim=0;
        }
        String typeName=((singleTypeNode)visit(ctx.singleType())).typeName;
        return new typeNode(new position(ctx),typeName,dim);
    }

    @Override
    public ASTNode visitSingleType(MxParser.SingleTypeContext ctx){

        if(ctx.Int()!=null){
            return new singleTypeNode(new position(ctx), "int");
        }else if(ctx.Bool()!=null){
            return new singleTypeNode(new position(ctx),"bool");
        }else if(ctx.String()!=null){
            return new singleTypeNode(new position(ctx),"string");
        }else if(ctx.Identifier()!=null){
            return new singleTypeNode(new position(ctx),ctx.Identifier().getText());
        }else{
            return null;
        }
    }

    @Override
    public ASTNode visitStatementBlock(MxParser.StatementBlockContext ctx){

        ArrayList<statementNode> statementList=new ArrayList<statementNode>();

        for(var item:ctx.statement()){
            statementList.add((statementNode) visit(item));
        }

        return new statementBlockNode(new position(ctx),statementList);
    }

    @Override
    public ASTNode visitStateBlock(MxParser.StateBlockContext ctx){

        return visit(ctx.statementBlock());
    }

    @Override
    public ASTNode visitVarDefine(MxParser.VarDefineContext ctx){

        return visit(ctx.varBlock());
    }

    @Override
    public ASTNode visitIf(MxParser.IfContext ctx){

        exprNode condition;
        statementNode trueState,falseState;

        condition=(exprNode) visit(ctx.experssion());
        trueState=(statementNode) visit(ctx.trueStatement);
        if(ctx.falseStatement==null){
            falseState=null;
        }else{
            falseState=(statementNode) visit(ctx.falseStatement);
        }

        return new ifNode(new position(ctx),condition,trueState,falseState);
    }

    @Override
    public ASTNode visitFor(MxParser.ForContext ctx){

        exprNode initExp,finishExp,stepExp;
        statementNode runStatement;

        initExp=(ctx.initExp==null)?null:(exprNode) visit(ctx.initExp);
        finishExp=(ctx.finishExp==null)?null:(exprNode) visit(ctx.finishExp);
        stepExp=(ctx.stepExp==null)?null:(exprNode) visit(ctx.stepExp);
        runStatement=(statementNode) visit(ctx.statement());

        return new forNode(new position(ctx),initExp,finishExp,stepExp,runStatement);
    }

    @Override
    public ASTNode visitWhile(MxParser.WhileContext ctx){

        return new whileNode(new position(ctx),(exprNode) visit(ctx.finishExp),(statementNode) visit(ctx.statement()));
    }

    @Override
    public ASTNode visitBreak(MxParser.BreakContext ctx){

        return new breakNode(new position(ctx));
    }

    @Override
    public ASTNode visitContinue(MxParser.ContinueContext ctx){

        return new continueNode(new position(ctx));
    }

    @Override
    public ASTNode visitRetStatement(MxParser.RetStatementContext ctx){

        return new retNode(new position(ctx),(ctx.experssion()==null)?null:(exprNode) visit(ctx.experssion()));
    }

    @Override
    public ASTNode visitExpStatement(MxParser.ExpStatementContext ctx){

        return new exprStatementNode(new position(ctx),(exprNode) visit(ctx.experssion()));
    }

    @Override
    public ASTNode visitEmptyStatement(MxParser.EmptyStatementContext ctx){

        return new emptyStatementNode(new position(ctx));
    }

    @Override
    public ASTNode visitAtomExpr(MxParser.AtomExprContext ctx){

        if(ctx.experssion()!=null){
            return visit(ctx.experssion());
        }else if(ctx.Identifier()!=null){
            return new varNode(new position(ctx),ctx.Identifier().getText());
        }else if(ctx.constValue()!=null){
            return visit(ctx.constValue());
        }else return null;
    }

    @Override
    public ASTNode visitNewArrayErr(MxParser.NewArrayErrContext ctx){

        throw new semanticError("[ASTBuilder][error new array] new array grammar error", new position(ctx));
    }

    @Override
    public ASTNode visitNewArray(MxParser.NewArrayContext ctx){

        ArrayList<exprNode> expr=new ArrayList<exprNode>();
        String arrayTypeName=((singleTypeNode)visit(ctx.singleType())).typeName;

        for(var item:ctx.experssion()){
            expr.add((exprNode) visit(item));
        }

        typeNode tmp=new typeNode(new position(ctx),arrayTypeName,ctx.LeftBracket().size());
        return new newArrayExprNode(new position(ctx),tmp,expr);
    }

    @Override
    public ASTNode visitNewInitObject(MxParser.NewInitObjectContext ctx){

        ArrayList<exprNode> expr=new ArrayList<exprNode>();
        for(var item:ctx.experssion()){
            expr.add((exprNode) visit(item));
        }
        return new newInitObjectExprNode(new position(ctx),(singleTypeNode) visit(ctx.singleType()),expr);
    }

    @Override
    public ASTNode visitNewObject(MxParser.NewObjectContext ctx){

        return new newObjectExprNode(new position(ctx),(singleTypeNode) visit(ctx.singleType()));
    }

    @Override
    public ASTNode visitClassMember(MxParser.ClassMemberContext ctx){

        return new classMemberExprNode(new position(ctx),(exprNode) visit(ctx.experssion()),ctx.Identifier().getText());
    }

    @Override
    public ASTNode visitArrayMember(MxParser.ArrayMemberContext ctx){

        return new arrayMemberExprNode(new position(ctx),(exprNode) visit(ctx.array),(exprNode) visit(ctx.index));
    }

    @Override
    public ASTNode visitFuncCall(MxParser.FuncCallContext ctx){

        exprNode funcExpr=(exprNode) visit(ctx.funcName);
        ArrayList<exprNode> paras=new ArrayList<exprNode>();

        for (var item:ctx.experssion()){
            paras.add((exprNode) visit(item));
        }

        if(funcExpr instanceof varNode){
            funcNode tmp=new funcNode(funcExpr.pos,((varNode)funcExpr).name);
            return new funcCallExprNode(new position(ctx),tmp,paras);
        }else if(funcExpr instanceof classMemberExprNode){
            methodNode tmp=new methodNode(funcExpr.pos,((classMemberExprNode) funcExpr).fatherExpr,((classMemberExprNode) funcExpr).memberName);
            return new funcCallExprNode(new position(ctx),tmp,paras);
        }else if(funcExpr instanceof lambdaExprNode){
            return new funcCallExprNode(new position(ctx),funcExpr,paras);
        }else{
            throw new semanticError("[ASTBuilder][error function call] func is not declared nor a class method",new position(ctx));
        }

    }

    @Override
    public ASTNode visitPostFixIncDec(MxParser.PostFixIncDecContext ctx){

        if(ctx.SelfAdd()!=null){
            return new postfixExprNode(new position(ctx),(exprNode) visit(ctx.experssion()), postfixExprNode.opType.selfAdd);
        }else if(ctx.SelfSub()!=null){
            return new postfixExprNode(new position(ctx),(exprNode) visit(ctx.experssion()), postfixExprNode.opType.selfSub);
        }else return null;
    }

    @Override
    public ASTNode visitUnaryExpr(MxParser.UnaryExprContext ctx){

        if(ctx.SelfAdd()!=null){
            return new unaryExprNode(new position(ctx),(exprNode) visit(ctx.experssion()), unaryExprNode.opType.selfAdd);
        }else if(ctx.SelfSub()!=null){
            return new unaryExprNode(new position(ctx),(exprNode) visit(ctx.experssion()), unaryExprNode.opType.selfSub);
        }else if(ctx.Add()!=null){
            return new unaryExprNode(new position(ctx),(exprNode) visit(ctx.experssion()), unaryExprNode.opType.positive);
        }else if(ctx.Sub()!=null){
            return new unaryExprNode(new position(ctx),(exprNode) visit(ctx.experssion()), unaryExprNode.opType.negative);
        }else if(ctx.LogicNot()!=null){
            return new unaryExprNode(new position(ctx),(exprNode) visit(ctx.experssion()), unaryExprNode.opType.logicNot);
        }else if(ctx.BitNot()!=null){
            return new unaryExprNode(new position(ctx),(exprNode) visit(ctx.experssion()), unaryExprNode.opType.bitNot);
        }else return null;
    }

    @Override
    public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx){

        exprNode leftExpr,rightExpr;
        leftExpr=(exprNode) visit(ctx.left);
        rightExpr=(exprNode) visit(ctx.right);

        if(leftExpr.isConst&&rightExpr.isConst){
            if(leftExpr instanceof intConstNode && rightExpr instanceof intConstNode){
                if(ctx.Mul()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value*((intConstNode) rightExpr).value);
                else if(ctx.Div()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value/((intConstNode) rightExpr).value);
                else if(ctx.Mod()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value%((intConstNode) rightExpr).value);
                else if(ctx.Add()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value+((intConstNode) rightExpr).value);
                else if(ctx.Sub()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value-((intConstNode) rightExpr).value);
                else if(ctx.BitLeft()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value<<((intConstNode) rightExpr).value);
                else if(ctx.BitRight()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value>>((intConstNode) rightExpr).value);
                else if(ctx.SmallThan()!=null)
                    return new boolConstNode(new position(ctx),((intConstNode) leftExpr).value<((intConstNode) rightExpr).value);
                else if(ctx.BigThan()!=null)
                    return new boolConstNode(new position(ctx),((intConstNode) leftExpr).value>((intConstNode) rightExpr).value);
                else if(ctx.SmallEqual()!=null)
                    return new boolConstNode(new position(ctx),((intConstNode) leftExpr).value<=((intConstNode) rightExpr).value);
                else if(ctx.BigEqual()!=null)
                    return new boolConstNode(new position(ctx),((intConstNode) leftExpr).value>=((intConstNode) rightExpr).value);
                else if(ctx.IsEqual()!=null)
                    return new boolConstNode(new position(ctx),((intConstNode) leftExpr).value==((intConstNode) rightExpr).value);
                else if(ctx.IsNotEqual()!=null)
                    return new boolConstNode(new position(ctx),((intConstNode) leftExpr).value!=((intConstNode) rightExpr).value);
                else if(ctx.BitAnd()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value&((intConstNode) rightExpr).value);
                else if(ctx.BitXor()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value^((intConstNode) rightExpr).value);
                else if(ctx.BitOr()!=null)
                    return new intConstNode(new position(ctx),((intConstNode) leftExpr).value|((intConstNode) rightExpr).value);
            }else if(leftExpr instanceof boolConstNode && rightExpr instanceof boolConstNode){
                if (ctx.IsEqual() != null)
                    return new boolConstNode(new position(ctx), ((boolConstNode)leftExpr).value == ((boolConstNode)rightExpr).value);
                else if (ctx.IsNotEqual() != null)
                    return new boolConstNode(new position(ctx), ((boolConstNode)leftExpr).value != ((boolConstNode)rightExpr).value);
                else if (ctx.LogicAnd() != null)
                    return new boolConstNode(new position(ctx), ((boolConstNode)leftExpr).value && ((boolConstNode)rightExpr).value);
                else if (ctx.LogicOr() != null)
                    return new boolConstNode(new position(ctx), ((boolConstNode)leftExpr).value || ((boolConstNode)rightExpr).value);
            }else if (leftExpr instanceof nullConstNode && rightExpr instanceof nullConstNode) {
                if (ctx.IsEqual() != null)
                    return new boolConstNode(new position(ctx), true);
                else if (ctx.IsNotEqual() != null)
                    return new boolConstNode(new position(ctx), false);
            }
        }

        if(ctx.Mul()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.mul,leftExpr,rightExpr);
        }else if(ctx.Div()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.div,leftExpr,rightExpr);
        }else if(ctx.Mod()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.mod,leftExpr,rightExpr);
        }else if(ctx.Add()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.add,leftExpr,rightExpr);
        }else if(ctx.Sub()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.sub,leftExpr,rightExpr);
        }else if(ctx.BitLeft()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.bitLeft,leftExpr,rightExpr);
        }else if(ctx.BitRight()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.bitRight,leftExpr,rightExpr);
        }else if(ctx.SmallThan()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.smallThan,leftExpr,rightExpr);
        }else if(ctx.BigThan()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.bigThan,leftExpr,rightExpr);
        }else if(ctx.SmallEqual()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.smallEqual,leftExpr,rightExpr);
        }else if(ctx.BigEqual()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.bigEqual,leftExpr,rightExpr);
        }else if(ctx.IsEqual()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.isEqual,leftExpr,rightExpr);
        }else if(ctx.IsNotEqual()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.isNotEqual,leftExpr,rightExpr);
        }else if(ctx.BitAnd()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.bitAnd,leftExpr,rightExpr);
        }else if(ctx.BitXor()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.bitXor,leftExpr,rightExpr);
        }else if(ctx.BitOr()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.bitOr,leftExpr,rightExpr);
        }else if(ctx.LogicAnd()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.logicAnd,leftExpr,rightExpr);
        }else if(ctx.LogicOr()!=null){
            return new binaryExprNode(new position(ctx), binaryExprNode.opType.logicOr,leftExpr,rightExpr);
        }else return null;
    }

    @Override
    public ASTNode visitAssign(MxParser.AssignContext ctx){

        return new assignExprNode(new position(ctx),(exprNode) visit(ctx.left),(exprNode) visit(ctx.right));
    }

    @Override
    public ASTNode visitLambdaExpr(MxParser.LambdaExprContext ctx){

        ArrayList<singleVarBlockNode> paras=new ArrayList<singleVarBlockNode>();
        statementBlockNode funcStatementBlock;

        for(int i = 0; i < ctx.type().size(); i++){
            singleVarBlockNode tmp=new singleVarBlockNode(new position(ctx),ctx.Identifier(i+1).getText(),null);
            tmp.type=(typeNode) visit(ctx.type(i));
            paras.add(tmp);
        }

        funcStatementBlock=(statementBlockNode) visit(ctx.statementBlock());
        return new lambdaExprNode(new position(ctx),paras,funcStatementBlock);
    }

    @Override
    public ASTNode visitConstValue(MxParser.ConstValueContext ctx){

        if(ctx.This()!=null){
            return new thisExprNode(new position(ctx));
        }else if(ctx.True()!=null){
            return new boolConstNode(new position(ctx),true);
        }else if(ctx.False()!=null){
            return new boolConstNode(new position(ctx),false);
        }else if(ctx.Null()!=null){
            return new nullConstNode(new position(ctx));
        }else if(ctx.IntegerConstant()!=null){
            return new intConstNode(new position(ctx),Integer.parseInt(ctx.IntegerConstant().getText()));
        }else if(ctx.StringConstant()!=null){
            return new stringConstNode(new position(ctx),ctx.StringConstant().getText());
        }else{
            return null;
        }
    }
}