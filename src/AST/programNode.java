package AST;

import AST.ASTNode;
import Util.position;

import java.util.ArrayList;

public class programNode extends ASTNode {
    public ArrayList<ASTNode> programBlockList;

    public programNode(position pos, ArrayList<ASTNode> programBlockList){
        super(pos);
        this.programBlockList=programBlockList;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
