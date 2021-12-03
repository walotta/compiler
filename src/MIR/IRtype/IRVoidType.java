package MIR.IRtype;

import MIR.Operand.IROperand;
import Util.error.compilerError;
import Util.position;

public class IRVoidType extends IRBaseType{

    @Override
    public int size() {
        throw new compilerError("void has no size!",new position(0,0));
    }

    @Override
    public String toString(){
        return "void";
    }

    @Override
    public IROperand defaultValue(){
        throw new IllegalStateException();
    }
}
