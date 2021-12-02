package MIR.IRInstruction;

import MIR.Operand.IROperand;
import MIR.Operand.Label;
import MIR.Operand.Register;

public class brInst extends Instruction{
    IROperand cond;
    Label trueLabel;
    Label falseLabel;

    public brInst(IROperand cond,Label trueLabel,Label falseLabel){
        this.cond=cond;
        this.trueLabel=trueLabel;
        this.falseLabel=falseLabel;
        this.blockFinish=true;
    }

    @Override
    public String toString() {
        if(falseLabel!=null)
            return "br i1 "+cond+", "+trueLabel.type+" "+trueLabel+", "+falseLabel.type+" "+falseLabel;
        else
            return "br i1 "+cond+", "+trueLabel.type+" "+trueLabel;
    }
}