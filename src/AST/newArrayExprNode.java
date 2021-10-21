package AST;

import Util.position;

import java.util.ArrayList;

public class newArrayExprNode extends exprNode{

    public typeNode arrayType;
    public ArrayList<exprNode> ExprList;

    public newArrayExprNode(position pos,typeNode arrayType,ArrayList<exprNode> dimExprList){
        super(pos,true);
        this.arrayType=arrayType;
        this.ExprList=dimExprList;
    }

}
