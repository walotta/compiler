package MIR;

import MIR.IRInstruction.Instruction;
import MIR.Operand.Label;

import java.util.LinkedList;
import java.util.StringJoiner;

public class BasicBlock {
    Label label;
    LinkedList<Instruction> instructions;

    public BasicBlock(Label label){
        this.label=label;
        instructions=new LinkedList<>();
    }

    @Override
    public String toString(){
        String tab="  ";
        StringJoiner builder=new StringJoiner("\n");
        builder.add(label.printLabel());
        instructions.forEach(item->builder.add(tab+item.toString()));
        return builder.toString();
    }

}
