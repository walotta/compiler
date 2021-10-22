package AST;

import Util.position;

import java.util.ArrayList;

public class newInitObjectExprNode extends exprNode{
    public singleTypeNode objectType;
    public ArrayList<exprNode> exprList;

    public newInitObjectExprNode(position pos,singleTypeNode objectType,ArrayList<exprNode> exprList){
        //左值未定义，但是不报错
        super(pos,true);
        this.objectType=objectType;
        this.exprList=exprList;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
