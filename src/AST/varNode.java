package AST;

import Util.position;

public class varNode extends exprNode{

    public String name;

    public varNode(position pos,String name){
        super(pos,true);
        this.name=name;
    }
}
