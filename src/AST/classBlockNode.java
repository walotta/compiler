package AST;

import Util.position;

import java.util.ArrayList;

public class classBlockNode extends ASTNode{
    public String className;
    ArrayList<funcBlockNode> funcList;
    ArrayList<varBlockNode> varLists;
    ArrayList<buildFuncBlockNode> buildFuncList;

    public classBlockNode(position pos,String className,ArrayList<funcBlockNode> funcList,ArrayList<varBlockNode> varLists,ArrayList<buildFuncBlockNode> buildFuncList){
        super(pos);
        this.className=className;
        this.funcList=funcList;
        this.varLists=varLists;
        this.buildFuncList=buildFuncList;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
