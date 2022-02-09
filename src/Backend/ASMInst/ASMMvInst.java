package Backend.ASMInst;

import Backend.ASMOperand.ASMReg;

public class ASMMvInst extends ASMInstBase{
    public ASMMvInst(ASMReg rd,ASMReg rs1){
        super(rd,rs1,null);
    }

    @Override
    public String toString(){
        return "mv "+rd+", "+rs1;
    }
}
