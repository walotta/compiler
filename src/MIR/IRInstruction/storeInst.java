package MIR.IRInstruction;

import MIR.IRtype.IRBaseType;
import MIR.Operand.IROperand;
import MIR.Operand.Register;

public class storeInst extends Instruction{
    IROperand source;
    Register target;

    public storeInst(IROperand source, Register target){
        this.source=source;
        this.target=target;
    }

    @Override
    public String toString(){
        return "store "+source.type+" "+source+", "+target.type+" "+target;
    }
}
