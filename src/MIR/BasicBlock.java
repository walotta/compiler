package MIR;

import MIR.IRInstruction.Instruction;
import MIR.Operand.Label;
import Util.error.compilerError;
import Util.position;

import java.util.LinkedList;
import java.util.StringJoiner;

public class BasicBlock {
    public Label label;
    public LinkedList<Instruction> instructions;

    public void pushInstruction(Instruction inst){
        if(!instructions.isEmpty()&&instructions.getLast().blockFinish)
            throw new compilerError("add inst after finish",new position(0,0));
        instructions.add(inst);
    }

    public boolean canInsert(){
        return instructions.isEmpty() || !instructions.getLast().blockFinish;
    }

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

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
