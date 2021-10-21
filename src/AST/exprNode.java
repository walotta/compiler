package AST;

import Util.Type.Type;
import Util.position;

abstract public class exprNode extends ASTNode{
    public Type type;
    public boolean isAssignable;

    public boolean isConst=false;

    public exprNode(position pos, boolean isAssignable){
        super(pos);
        this.isAssignable=isAssignable;
    }
}
