package MIR.IRInstruction;

import MIR.Operand.Register;

public class brInst extends Instruction{
    Register cond;
    int trueLabel;
    int falseLabel;

    public brInst(Register cond,int trueLabel,int falseLabel){
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
