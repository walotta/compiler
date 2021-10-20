package AST;

import Util.position;

import java.util.ArrayList;

public class statementBlockNode extends statementNode {

    public ArrayList<statementNode> statementList;

    public statementBlockNode(position pos){
        super(pos);
        this.statementList=null;
    }

}
