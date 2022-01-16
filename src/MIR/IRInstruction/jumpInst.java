package MIR.IRInstruction;

import MIR.IRVisitor;
import MIR.Operand.Label;

public class jumpInst extends Instruction{
    public Label target;

    public jumpInst(Label target){
        this.target=target;
        this.blockFinish=true;
    }

    @Override
    public String toString() {
        return "br label "+target;
    }

    @Override
    public Object accept(IRVisitor visitor){
        return visitor.visit(this);
    }
}
