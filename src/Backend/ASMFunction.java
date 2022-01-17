package Backend;

import Backend.ASMOperand.ASMOperandBase;
import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.VirtualReg;
import MIR.Operand.IROperand;
import MIR.Operand.Register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class ASMFunction {
    String funcName;
    int funcId;
    ArrayList<ASMBlock> blocks;
    LinkedHashMap<Integer, ASMReg> renameTable;
    ArrayList<VirtualReg> tmpReg;
    StackManager stackManager;
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
        VirtualReg newReg=new VirtualReg(-1);
        tmpReg.add(newReg);
        return newReg;
    }

    ASMFunction(String funcName,int funcId){
        this.funcName=funcName;
        this.funcId=funcId;
        this.blocks=new ArrayList<>();
        this.stackManager=new StackManager();
        this.renameTable=new LinkedHashMap<>();
        this.tmpReg=new ArrayList<>();
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
