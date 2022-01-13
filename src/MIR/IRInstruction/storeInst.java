package MIR.IRInstruction;

import MIR.IRtype.IRBaseType;
import MIR.IRtype.IRPointerType;
import MIR.Operand.IROperand;
import MIR.Operand.Register;

public class storeInst extends Instruction{
    public IROperand source;
    public Register target;

    public storeInst(IROperand source, Register target){
        this.source=source;
        this.target=target;
    }

    @Override
    public String toString(){
        return "store "+((IRPointerType)target.type).baseType+" "+source+", "+target.type+" "+target;
    }
}
