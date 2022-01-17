package Backend.ASMInst;

import Backend.ASMOperand.ASMOperandBase;
import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.Immediate;

public class ASMCalInst extends ASMInstBase{
    public enum op{
        add, addi, sub,  lui,  auipc, mul, muli, sdiv, srem,
        xor, xori, or,   ori,  and,   andi,
        sll, slli, srl,  srli, sra,   srai,
        slt, slti, sltu, sltiu
    }

    op InstOpt;

    public ASMCalInst(op InstOpt,ASMReg rd,ASMReg rs1,ASMOperandBase rs2){
        super(rd,rs1,rs2);
        this.InstOpt=InstOpt;
    }

    @Override
    public String toString(){
        if(rs2!=null)
            return InstOpt+" "+rd+", "+rs1+", "+rs2;
        else
            return InstOpt+" "+rd+", "+rs1;
    }
}
