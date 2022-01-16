package Backend.ASMInst;

import Backend.ASMOperand.ASMOperandBase;
import Backend.ASMOperand.ASMReg;

abstract public class ASMInstBase {
    public ASMOperandBase rd;
    public ASMOperandBase rs1;
    public ASMOperandBase rs2;

    public ASMInstBase(ASMOperandBase rd,ASMOperandBase rs1,ASMOperandBase rs2){
        this.rd=rd;
        this.rs1=rs1;
        this.rs2=rs2;
    }

    String comment=null;
    protected String printComment(){
        if(comment==null)
            return "";
        else
            return "\t# "+comment;
    }
}
