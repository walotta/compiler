package AST;

import Util.position;

public class boolConstNode extends constExprNode{
    public boolean value;

    public boolConstNode(position pos, boolean value){
        super(pos);
        this.value=value;
    }

}
