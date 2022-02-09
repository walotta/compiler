package Backend.ASMInst;

import Backend.ASMOperand.ASMOperandBase;
import Backend.ASMOperand.ASMReg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

abstract public class ASMInstBase {
    public ASMOperandBase rd;
    public ASMOperandBase rs1;
    public ASMOperandBase rs2;
    public LinkedList<ASMInstBase> pred;
    public LinkedList<ASMInstBase> succ;
    public HashSet<ASMReg> use;
    public HashSet<ASMReg> def;
    public HashSet<ASMReg> in;
    public HashSet<ASMReg> out;

    public ASMInstBase(ASMOperandBase rd,ASMOperandBase rs1,ASMOperandBase rs2){
        this.rd=rd;
        this.rs1=rs1;
        this.rs2=rs2;
        this.pred=new LinkedList<>();
        this.succ=new LinkedList<>();
        this.use=new HashSet<>();
        this.def=new HashSet<>();
        this.in=new HashSet<>();
        this.out=new HashSet<>();
    }

    public void saveToUse(ASMOperandBase reg){
        if(reg instanceof ASMReg)
            use.add((ASMReg) reg);
    }

    public void saveToDef(ASMOperandBase reg){
        if(reg instanceof ASMReg)
            def.add((ASMReg) reg);
    }

    String comment=null;
    protected String printComment(){
        if(comment==null)
            return "";
        else
            return "\t# "+comment;
    }
}
