package Backend.ASMInst;

import Backend.ASMLabel;
import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.Immediate;

public class ASMFakeInst extends ASMInstBase{
    public enum op{
        li, mv, bnez, j, call
    }
    op InstOpt;
    ASMLabel targetLabel;
    String FuncName;
    public ASMFakeInst(op InstOpt,ASMReg rd,Immediate imm){
        super(rd,imm,null);
        this.InstOpt=InstOpt;
    }

    public ASMFakeInst(op InstOpt,ASMReg rd,ASMReg rs1,ASMReg rs2){
        super(rd,rs1,rs2);
        this.InstOpt=InstOpt;
    }

    public ASMFakeInst(op InstOpt,ASMReg rs1,ASMLabel targetLabel){
        super(null,rs1,null);
        this.InstOpt=InstOpt;
        this.targetLabel=targetLabel;
    }

    public ASMFakeInst(op instOpt,ASMLabel targetLabel){
        super(null,null,null);
        this.InstOpt=instOpt;
        this.targetLabel=targetLabel;
    }

    public ASMFakeInst(op instOpt,String funcName){
        super(null,null,null);
        this.InstOpt=instOpt;
        this.FuncName=funcName;
    }

    @Override
    public String toString(){
        if(InstOpt==op.li)
            return InstOpt+" "+rd+", "+rs1;
        else if(InstOpt==op.mv)
            return InstOpt+" "+rd+", "+rs1;
        else if(InstOpt==op.bnez)
            return InstOpt+" "+rs1+", "+targetLabel;
        else if(InstOpt==op.j)
            return InstOpt+" "+targetLabel;
        else if(InstOpt==op.call)
            return InstOpt+" "+FuncName;
        else return null;
    }
}
