package MIR.IRtype;

import MIR.Operand.IROperand;
import Util.error.compilerError;
import Util.position;

public class IRNullType extends IRBaseType{
    //todo delete

    @Override
    public int size() {
        throw new compilerError("null has no size!",new position(0,0));
    }

    @Override
    public String toString(){
        return "null";
    }

    @Override
    public IROperand defaultValue() {
        return null;
    }
}
