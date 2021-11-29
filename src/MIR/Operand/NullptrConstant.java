package MIR.Operand;

import MIR.IRtype.IRPointerType;

public class NullptrConstant extends IROperand{
    public NullptrConstant(IRPointerType type){
        super(type);
    }

    @Override
    public String toString() {
        return "null";
    }
}
