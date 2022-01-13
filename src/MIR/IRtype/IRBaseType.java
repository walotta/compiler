package MIR.IRtype;

import MIR.Operand.IROperand;

abstract public class IRBaseType {
    public static int pointSize;
    abstract public String toString();
    abstract public IROperand defaultValue();
    abstract public int size();
}
