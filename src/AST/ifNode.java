package AST;

import Util.position;

public class ifNode extends statementNode{
    public exprNode condition;
    public statementNode trueStatement,falseStatement;

    public ifNode(position pos,exprNode condition,statementNode trueStatement,statementNode falseStatement){
        super(pos);
        this.condition=condition;
        this.trueStatement=trueStatement;
        this.falseStatement=falseStatement;
    }


}
