package AST;

import Util.position;

abstract public class constExprNode extends exprNode{

    public constExprNode(position pos){
        super(pos,false);
        this.isConst=true;
    }

}
