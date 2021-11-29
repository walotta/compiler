package MIR;

import MIR.IRInstruction.Instruction;

import java.util.LinkedList;
import java.util.StringJoiner;

public class BasicBlock {
    int id;
    LinkedList<Instruction> instructions;

    public BasicBlock(int id){
        this.id=id;
        instructions=new LinkedList<>();
    }

    @Override
    public String toString(){
        String tab="  ";
        StringJoiner builder=new StringJoiner("\n");
        builder.add(id+":");
        instructions.forEach(item->builder.add(tab+item.toString()));
        return builder.toString();
    }

}
