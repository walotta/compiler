package AST;

import Util.position;

public class newObjectExprNode extends exprNode{
    singleTypeNode objectType;

    public newObjectExprNode(position pos,singleTypeNode objectType){
        super(pos,true);
        this.objectType=objectType;
    }

}
