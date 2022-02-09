package Backend.RegisterAllocation;

import Backend.ASMBlock;
import Backend.ASMFunction;
import Backend.ASMInst.ASMInstBase;
import Backend.ASMInst.ASMRetInst;
import Backend.ASMModule;
import Backend.ASMOperand.ASMReg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class livenessAnalysis {
    ASMModule module;
    HashMap<ASMInstBase, HashSet<ASMReg>> inHistory;
    HashMap<ASMInstBase, HashSet<ASMReg>> outHistory;

    public livenessAnalysis(ASMModule module){
        this.module=module;
    }

    public ASMModule run(){
        while(!check())
            recursive();
        return module;
    }

    boolean check(){
        if(inHistory==null || outHistory==null)
            return false;
        else{
            for (Map.Entry<String, ASMFunction> entry : module.funcs.entrySet()) {
                ASMFunction func = entry.getValue();
                for (ASMBlock block : func.blocks) {
                    for (ASMInstBase inst : block.insts) {
                        if (!(inHistory.get(inst).equals(inst.in) && outHistory.get(inst).equals(inst.out)))
                            return false;
                    }
                }
            }
            return true;
        }
    }

    void recursive(){
        inHistory=new HashMap<>();
        outHistory=new HashMap<>();
        for (Map.Entry<String, ASMFunction> entry : module.funcs.entrySet()) {
            ASMFunction func = entry.getValue();
            for (ASMBlock block : func.blocks) {
                for (ASMInstBase inst : block.insts) {
                    inHistory.put(inst,new HashSet<>(inst.in));
                    outHistory.put(inst,new HashSet<>(inst.out));

                    HashSet<ASMReg> delta=new HashSet<>(inst.out);
                    delta.removeAll(inst.def);
                    HashSet<ASMReg> sum=new HashSet<>(inst.use);
                    sum.addAll(delta);
                    inst.in=sum;

                    inst.out=new HashSet<>();
                    inst.succ.forEach(s->inst.out.addAll(s.in));
                }
            }
        }
    }
}
