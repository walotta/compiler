package AST;

import Util.position;

import java.util.ArrayList;

public class varBlockNode extends statementNode{
    public typeNode type;
    public ArrayList<singleVarBlockNode> varList;

    public varBlockNode(position pos, typeNode type, ArrayList<singleVarBlockNode> varList){
        super(pos);
        this.type=type;
        this.varList=varList;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
