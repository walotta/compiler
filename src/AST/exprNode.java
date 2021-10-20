package AST;

import Util.Type.Type;
import Util.position;

public class exprNode extends ASTNode{
    public Type type;
    public boolean isAssignable=false;

    public exprNode(position pos, boolean isAssignable){
        super(pos);
        this.isAssignable=isAssignable;
    }
}
