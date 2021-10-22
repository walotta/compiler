package AST;

import Util.position;

public class retNode extends statementNode{

    public exprNode returnExp;

    public retNode(position pos,exprNode returnExp){
        super(pos);
        this.returnExp=returnExp;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
