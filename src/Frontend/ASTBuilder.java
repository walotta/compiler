package Frontend;

import AST.*;
import Parser.MxBaseVisitor;
import Parser.MxParser;
import Util.position;

import java.util.ArrayList;
public class ASTBuilder extends MxBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(MxParser.ProgramContext ctx){
        ArrayList<ASTNode> tmp=new ArrayList<ASTNode>();
        for (var item:ctx.programBlock()){
            tmp.add((ASTNode) visit(item));
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
        //todo
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
        //todo
    }

    @Override
    public ASTNode visitVarDefine(MxParser.VarBlockContext ctx){
        //todo
    }

    @Override
    public ASTNode visitIf(MxParser.IfContext ctx){
        //todo
    }

    @Override
    public ASTNode visitFor(MxParser.ForContext ctx){
        //todo
    }

    @Override
    public ASTNode visitWhile(MxParser.WhileContext ctx){
        //todo
    }

    @Override
    public ASTNode visitBreak(MxParser.BreakContext ctx){
        //todo
    }

    @Override
    public ASTNode visitContinue(MxParser.ContinueContext ctx){
        //todo
    }

    @Override
    public ASTNode visitRetStatement(MxParser.RetStatementContext ctx){
        //todo
    }

    @Override
    public ASTNode visitExpStatement(MxParser.ExpStatementContext ctx){
        //todo
    }

    @Override
    public ASTNode visitAtomExpr(MxParser.AtomExprContext ctx){
        //todo
    }

    @Override
    public ASTNode visitNewArrayErr(MxParser.NewArrayErrContext ctx){
        //todo
    }

    @Override
    public ASTNode visitNewArray(MxParser.NewArrayContext ctx){
        //todo
    }

    @Override
    public ASTNode visitNewInitObject(MxParser.NewInitObjectContext ctx){
        //todo
    }

    @Override
    public ASTNode visitNewObject(MxParser.NewObjectContext ctx){
        //todo
    }

    @Override
    public ASTNode visitClassMember(MxParser.ClassMemberContext ctx){
        //todo
    }

    @Override
    public ASTNode visitArrayMember(MxParser.ArrayMemberContext ctx){
        //todo
    }

    @Override
    public ASTNode visitFuncCall(MxParser.FuncCallContext ctx){
        //todo
    }

    @Override
    public ASTNode visitPostFixIncDec(MxParser.PostFixIncDecContext ctx){
        //todo
    }

    @Override
    public ASTNode visitUnaryExpr(MxParser.UnaryExprContext ctx){
        //todo
    }

    @Override
    public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx){
        //todo
    }

    @Override
    public ASTNode visitAssign(MxParser.AssignContext ctx){
        //todo
    }

    @Override
    public ASTNode visitLambdaExp(MxParser.LambdaExpContext ctx){
        //todo
    }

}