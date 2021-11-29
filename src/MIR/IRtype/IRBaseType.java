package MIR.IRtype;

import MIR.Operand.IROperand;

abstract public class IRBaseType {
    abstract public String toString();
    abstract public IROperand defaultValue();
}
