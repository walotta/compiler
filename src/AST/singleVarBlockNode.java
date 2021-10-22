package AST;

import Util.position;

public class singleVarBlockNode extends ASTNode{
    public typeNode type;
    public String VarName;
    public exprNode expr;

    public singleVarBlockNode(position pos, String VarName, exprNode expr){
        super(pos);
        this.VarName=VarName;
        this.expr=expr;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
