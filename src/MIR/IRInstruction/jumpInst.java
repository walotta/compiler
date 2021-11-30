package MIR.IRInstruction;

import MIR.Operand.Label;

public class jumpInst extends Instruction{
    Label target;

    public jumpInst(Label target){
        this.target=target;
        this.blockFinish=true;
    }

    @Override
    public String toString() {
        return "br label "+target;
    }
}
