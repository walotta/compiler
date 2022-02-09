package Backend.RegisterAllocation.interferenceGraph.graph;

import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.PhysicalReg;
import Backend.ASMOperand.VirtualReg;
import Util.error.compilerError;
import Util.position;

import java.util.LinkedHashMap;

public class nodeMap {
    LinkedHashMap<PhysicalReg,graphNode> phyMap;
    LinkedHashMap<VirtualReg,graphNode> virtualMap;

    public nodeMap(){
        this.phyMap=new LinkedHashMap<>();
        this.virtualMap=new LinkedHashMap<>();
    }

    public boolean contains(ASMReg reg){
        if(reg instanceof PhysicalReg)
            return phyMap.containsKey(reg);
        else if(reg instanceof VirtualReg)
            return virtualMap.containsKey(reg);
        else throw new compilerError("asmReg is an interface!",new position(0,0));
    }

    public graphNode get(ASMReg reg){
        if(reg instanceof PhysicalReg)
            return phyMap.get(reg);
        else if(reg instanceof VirtualReg)
            return virtualMap.get(reg);
        else return null;
    }

    public void put(ASMReg reg,graphNode node){
        if(reg instanceof PhysicalReg)
            phyMap.put((PhysicalReg) reg,node);
        else if(reg instanceof VirtualReg)
            virtualMap.put((VirtualReg) reg,node);
        else throw new compilerError("asmReg is an interface!",new position(0,0));
    }
}
