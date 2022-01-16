package Backend.ASMInst;

import Backend.ASMOperand.ASMGlobalVarBase;
import Backend.ASMOperand.ASMReg;

public class ASMLaInst extends ASMInstBase{
    public ASMLaInst(ASMReg target, ASMGlobalVarBase source){
        super(target,source,null);
    }

    @Override
    public String toString(){
        return "la "+rd+", "+rs1;
    }
}
