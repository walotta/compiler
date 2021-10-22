package AST;

import Util.position;

public class emptyStatementNode extends statementNode{

    public emptyStatementNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
