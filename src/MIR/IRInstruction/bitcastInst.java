package MIR.IRInstruction;

import MIR.Operand.IROperand;
import MIR.Operand.Register;

public class bitcastInst extends Instruction{
    Register target;
    IROperand source;

    public bitcastInst(IROperand source,Register target){
        this.source=source;
        this.target=target;
    }

    public String toString(){
        return target+" = bitcast "+source.type+" "+source+" to "+target.type;
    }
}
