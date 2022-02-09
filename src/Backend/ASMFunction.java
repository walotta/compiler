package Backend;

import Backend.ASMInst.ASMInstBase;
import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.VirtualReg;
import MIR.Operand.Register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class ASMFunction {
    public String funcName;
    int funcId;
    public ArrayList<ASMBlock> blocks;
    public HashMap<ASMLabel,Integer> blocksMap;
    public ArrayList<ASMInstBase> retToInst;
    LinkedHashMap<Integer, ASMReg> renameTable;
    public StackManager stackManager;
    int callerAddr;

    public void defineReg(Register irReg,ASMReg newReg){
        renameTable.put(irReg.renameId,newReg);
    }

    public ASMReg getReg(Register irReg){
        if(renameTable.containsKey(irReg.renameId))
            return renameTable.get(irReg.renameId);
        else{
            VirtualReg newReg=new VirtualReg(irReg.renameId);
            renameTable.put(irReg.renameId,newReg);
            return newReg;
        }
    }

    public ASMReg getTmpReg(){
        return new VirtualReg(-1);
    }

    ASMFunction(String funcName,int funcId){
        this.funcName=funcName;
        this.funcId=funcId;
        this.blocks=new ArrayList<>();
        this.blocksMap=new HashMap<>();
        this.retToInst =new ArrayList<>();
        this.stackManager=new StackManager();
        this.renameTable=new LinkedHashMap<>();
    }

    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        builder.append("\t.globl\t").append(funcName).append("\t# -- Begin function\t").append(funcName).append('\n');
        builder.append("\t.type\t").append(funcName).append(",@function\n");
        builder.append(funcName).append(":\t# ").append(funcName).append('\n');
        StringJoiner joiner=new StringJoiner("\n");
        blocks.forEach(item->joiner.add(item.toString()));
        builder.append(joiner);
        builder.append('\n');
        builder.append(".Lfunc_end").append(funcId).append(":\n");
        builder.append("\t.size\t").append(funcName).append(", .Lfunc_end").append(funcId).append("-").append(funcName).append('\n');
        builder.append("\t# -- End function");
        return builder.toString();
    }
}
