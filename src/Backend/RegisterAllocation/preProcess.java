package Backend.RegisterAllocation;

import Backend.ASMInst.*;
import Backend.ASMModule;

public class preProcess {
    ASMModule module;

    public preProcess(ASMModule module){
        this.module=module;
    }

    public ASMModule run(){
        analysisDataFlow();
        analysisDefUse();
        return module;
    }

    void analysisDataFlow(){
        module.funcs.forEach((funcName,func)->{
            for(int i=0;i<func.blocks.size();i++){
                func.blocksMap.put(func.blocks.get(i).label,i);
            }
        });
        module.funcs.forEach((funcName,func)-> func.blocks.forEach(block->{
            for(int i=0;i<block.insts.size();i++){
                ASMInstBase inst=block.insts.get(i);
                if(inst instanceof ASMJumpInst){
                    switch (((ASMJumpInst) inst).InstOpt){
                        case bnez -> {
                            inst.succ.push(block.insts.get(i+1));
                            block.insts.get(i+1).pred.push(inst);
                            int jumpId=func.blocksMap.get(((ASMJumpInst) inst).targetLabel);
                            inst.succ.push(func.blocks.get(jumpId).insts.get(0));
                            func.blocks.get(jumpId).insts.get(0).pred.push(inst);
                        }
                        case j -> {
                            int jumpId=func.blocksMap.get(((ASMJumpInst) inst).targetLabel);
                            inst.succ.push(func.blocks.get(jumpId).insts.get(0));
                            func.blocks.get(jumpId).insts.get(0).pred.push(inst);
                        }
                        case call -> {
                            inst.succ.push(module.funcs.get(((ASMJumpInst) inst).FuncName).blocks.get(0).insts.get(0));
                            module.funcs.get(((ASMJumpInst) inst).FuncName).blocks.get(0).insts.get(0).pred.push(inst);
                            if(i+1!=block.insts.size()){
                                module.funcs.get(((ASMJumpInst) inst).FuncName).retToInst.add(block.insts.get(i+1));
                            }
                        }
                    }
                }else if(!(inst instanceof ASMRetInst)){
                    inst.succ.push(block.insts.get(i+1));
                    block.insts.get(i+1).pred.push(inst);
                }
            }
        }));
        module.funcs.forEach((funcName,func)->{
            func.blocks.forEach(block->{
                block.insts.forEach(inst->{
                    if(inst instanceof ASMRetInst){
                        inst.succ.addAll(func.retToInst);
                        func.retToInst.forEach(rInst->rInst.pred.add(inst));
                    }
                });
            });
        });
    }

    void analysisDefUse(){
        module.funcs.forEach((funcName,func)->
            func.blocks.forEach(block->
                block.insts.forEach(inst->{
                    if(inst instanceof ASMMemoryInst && ((ASMMemoryInst) inst).isSave())
                        inst.saveToUse(inst.rd);
                    else
                        inst.saveToDef(inst.rd);
                    inst.saveToUse(inst.rs1);
                    inst.saveToDef(inst.rs2);
        })));
    }
}
