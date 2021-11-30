package MIR.IRInstruction;

import MIR.Operand.Label;
import MIR.Operand.Register;

public class brInst extends Instruction{
    Register cond;
    Label trueLabel;
    Label falseLabel;

    public brInst(Register cond,Label trueLabel,Label falseLabel){
        this.cond=cond;
        this.trueLabel=trueLabel;
        this.falseLabel=falseLabel;
        this.blockFinish=true;
    }

    @Override
    public String toString() {
        return "br i1 "+cond+", %"+trueLabel+", %"+falseLabel;
    }
}
