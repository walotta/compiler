package Backend.RegisterAllocation.interferenceGraph;

import Backend.ASMInst.ASMMvInst;
import Backend.ASMModule;
import Backend.RegisterAllocation.interferenceGraph.graph.graphBase;

public class interferenceGraphBuilder {
    graphBase retGraph;

    public graphBase run(ASMModule asmModule){
        retGraph=new graphBase();
        asmModule.funcs.forEach((funcName,func)->
            func.blocks.forEach(block->
                block.insts.forEach(inst->
                    inst.def.forEach(d->{
                        if(inst instanceof ASMMvInst){
                            //mv inst
                            inst.out.forEach(out->{
                                if(out.equals(inst.rd))
                                    retGraph.addMvEdge(d,out);
                                else
                                    retGraph.addNormalEdge(d,out);
                            });
                        }else{
                            //not mv
                            inst.out.forEach(out->retGraph.addNormalEdge(d,out));
                        }
                }))));
        return retGraph;
    }
}
