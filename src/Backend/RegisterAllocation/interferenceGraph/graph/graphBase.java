package Backend.RegisterAllocation.interferenceGraph.graph;

import Backend.ASMOperand.ASMReg;

public class graphBase {
    nodeMap regToNode;

    public graphBase(){
        regToNode=new nodeMap();
    }

    public graphNode getNode(ASMReg reg){
        if(regToNode.contains(reg))
            return regToNode.get(reg);
        else{
            graphNode node=new graphNode(reg);
            regToNode.put(reg,node);
            return node;
        }
    }

    public void addNormalEdge(ASMReg reg1,ASMReg reg2){
        graphNode node1=getNode(reg1);
        graphNode node2=getNode(reg2);
        node1.normalEdge.add(node2);
        node2.normalEdge.add(node1);
    }

    public void addMvEdge(ASMReg reg1,ASMReg reg2){
        graphNode node1=getNode(reg1);
        graphNode node2=getNode(reg2);
        node1.mvEdge.add(node2);
        node2.mvEdge.add(node1);
    }
}
