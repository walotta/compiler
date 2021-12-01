package MIR.IRInstruction;

import MIR.Operand.IROperand;
import MIR.Operand.Register;

public class compareInst extends Instruction{

    public IROperand leftOperand,rightOperand;
    public compareType type;
    public Register target;

    public compareInst(compareType type,IROperand leftOperand,IROperand rightOperand,Register target){
        this.type=type;
        this.leftOperand=leftOperand;
        this.rightOperand=rightOperand;
        this.target=target;
    }

    public enum compareType{
        eq,     // ==
        ne,     // !=
        sgt,    // >
        sge,    // >=
        slt,    // <
        sle     // <=
    }

    @Override
    public String toString() {
        return target+" = icmp "+type+" "+leftOperand.type+" "+leftOperand+", "+rightOperand;
    }
}
