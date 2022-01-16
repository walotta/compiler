package Backend.ASMInst;

import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.Immediate;

public class ASMMemoryInst extends ASMInstBase{
    public enum op{
        lb, lh, lw,
        lbu,lhu,
        sb, sh, sw
    }
    op InstOpt;
    //info->rd addr->rs1 offset->rs2

    public ASMMemoryInst(op InstOpt,ASMReg info,ASMReg addr,Immediate offset){
        super(info,addr,offset);
        this.InstOpt=InstOpt;
    }

    @Override
    public String toString(){
        return InstOpt+" "+rd+", "+rs2+"("+rs1+")";
    }
}
