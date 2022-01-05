package MIR.IRtype;

import MIR.Operand.IROperand;
import Util.error.compilerError;
import Util.position;

public class IRCharType extends IRBaseType{

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String toString() {
        return "i8";
    }

    @Override
    public IROperand defaultValue() {
        throw new compilerError("cannot define char var",new position(0,0));
    }
}
