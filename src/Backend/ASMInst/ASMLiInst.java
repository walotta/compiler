package Backend.ASMInst;

import Backend.ASMOperand.ASMGlobalVarBase;
import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.Immediate;

public class ASMLiInst extends ASMInstBase{
    public ASMLiInst(ASMReg target, Immediate source){
        super(target,source,null);
    }

    @Override
    public String toString(){
        return "li "+rd+", "+rs1+printComment();
    }
}
