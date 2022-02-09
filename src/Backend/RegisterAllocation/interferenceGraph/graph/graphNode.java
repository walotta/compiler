package Backend.RegisterAllocation.interferenceGraph.graph;

import Backend.ASMOperand.ASMReg;

import java.util.LinkedHashSet;

public class graphNode {
    ASMReg nodeReg;
    LinkedHashSet<graphNode> normalEdge;
    LinkedHashSet<graphNode> mvEdge;

    public graphNode(ASMReg nodeReg){
        this.nodeReg=nodeReg;
        this.normalEdge=new LinkedHashSet<>();
        this.mvEdge=new LinkedHashSet<>();
    }
}
