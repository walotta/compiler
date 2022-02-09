package Backend.ASMInst;

import Backend.ASMLabel;
import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.Immediate;

public class ASMJumpInst extends ASMInstBase{
    public enum op{
        bnez, j, call
    }
    public op InstOpt;
    public ASMLabel targetLabel;
    public String FuncName;

    //bnez
    public ASMJumpInst(op InstOpt, ASMReg rs1, ASMLabel targetLabel){
        super(null,rs1,null);
        this.InstOpt=InstOpt;
        this.targetLabel=targetLabel;
    }

    //j
    public ASMJumpInst(op instOpt, ASMLabel targetLabel){
        super(null,null,null);
        this.InstOpt=instOpt;
        this.targetLabel=targetLabel;
    }

    //call
    public ASMJumpInst(op instOpt, String funcName){
        super(null,null,null);
        this.InstOpt=instOpt;
        this.FuncName=funcName;
    }

    @Override
    public String toString(){
        if(InstOpt==op.bnez)
            return InstOpt+" "+rs1+", "+targetLabel+printComment();
        else if(InstOpt==op.j)
            return InstOpt+" "+targetLabel+printComment();
        else if(InstOpt==op.call)
            return InstOpt+" "+FuncName+printComment();
        else return null;
    }
}
