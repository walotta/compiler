package AST;

import Util.position;

public class stringConstNode extends constExprNode{
    String value;

    public stringConstNode(position pos,String value){
        super(pos);
        this.value=value;
    }
}