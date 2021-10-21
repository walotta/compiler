package AST;

import Util.position;

public class whileNode extends statementNode{
    exprNode finishExp;
    statementNode runStatement;

    public whileNode(position pos,exprNode finishExp,statementNode runStatement){
        super(pos);
        this.finishExp=finishExp;
        this.runStatement=runStatement;
    }

}
