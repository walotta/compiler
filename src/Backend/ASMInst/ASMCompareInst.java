package Backend.ASMInst;

import Backend.ASMOperand.ASMOperandBase;
import Backend.ASMOperand.ASMReg;

public class ASMCompareInst extends ASMInstBase{
    public enum op{
        slt, slti, sltu, sltiu, seqz, snez
    }
    op instOpt;

    public ASMCompareInst(op instOpt,ASMReg rd,ASMReg rs1,ASMReg rs2){
        super(rd,rs1,rs2);
        this.instOpt=instOpt;
    }

    @Override
    public String toString(){
        if(rs2!=null)
            return instOpt+" "+rd+", "+rs1+", "+rs2+printComment();
        else
            return instOpt+" "+rd+", "+rs1+printComment();
    }
}
