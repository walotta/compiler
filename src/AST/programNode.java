package AST;

import AST.ASTNode;
import Util.position;

import java.util.ArrayList;

public class programNode extends ASTNode {
    public ArrayList<ASTNode> decls;

    public programNode(position pos, ArrayList<ASTNode> decls){
        super(pos);
        this.decls=decls;
    }
}
