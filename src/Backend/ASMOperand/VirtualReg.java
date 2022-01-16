package Backend.ASMOperand;

import Util.error.compilerError;
import Util.position;

public class VirtualReg extends ASMReg{
    int regId;

    public VirtualReg(int regId){
        this.regId=regId;
    }

    @Override
    public String toString(){
        throw new compilerError("virtualReg cannot print",new position(0,0));
    }
}
