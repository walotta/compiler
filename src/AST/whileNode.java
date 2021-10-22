package AST;

import Util.position;

public class whileNode extends statementNode{
    public exprNode finishExp;
    public statementNode runStatement;

    public whileNode(position pos,exprNode finishExp,statementNode runStatement){
        super(pos);
        this.finishExp=finishExp;
        this.runStatement=runStatement;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
