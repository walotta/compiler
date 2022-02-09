package Backend;

import Backend.ASMInst.ASMInstBase;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ASMBlock {
    public ASMLabel label;
    public ArrayList<ASMInstBase> insts;

    public ASMBlock(ASMLabel label){
        this.label=label;
        this.insts=new ArrayList<>();
    }

    @Override
    public String toString(){
        StringJoiner joiner=new StringJoiner("\n");
        joiner.add(label.toString()+":");
        insts.forEach(inst->joiner.add("\t"+inst.toString()));
        return joiner.toString();
    }
}
