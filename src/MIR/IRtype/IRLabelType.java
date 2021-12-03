package MIR.IRtype;

import MIR.Operand.IROperand;
import Util.error.compilerError;
import Util.position;

public class IRLabelType extends IRBaseType{

    @Override
    public int size() {
        throw new compilerError("label has no size!",new position(0,0));
    }

    @Override
    public String toString() {
        return "label";
    }

    @Override
    public IROperand defaultValue() {
        throw new compilerError("call default value for label type!",new position(0,0));
    }
}
