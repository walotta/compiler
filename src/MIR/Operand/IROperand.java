package MIR.Operand;

import MIR.IRtype.IRBaseType;

abstract public class IROperand {
    public IRBaseType type;

    public IROperand(IRBaseType type){
        this.type=type;
    }

    abstract public String toString();
}
