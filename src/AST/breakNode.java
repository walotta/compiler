package AST;

import Util.position;

public class breakNode extends statementNode{

    public breakNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
