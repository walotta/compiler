package MIR.IRInstruction;

import MIR.IRVisitor;
import MIR.IRtype.IRArrayType;
import MIR.IRtype.IRClassType;
import MIR.IRtype.IRPointerType;
import MIR.Operand.IROperand;
import MIR.Operand.Register;
import Util.error.compilerError;
import Util.position;

public class getElementInst extends Instruction{
    public Register target;
    public IROperand header;
    public IROperand index;

    public getElementInst(Register target,IROperand header,IROperand index){
        this.target=target;
        this.header=header;
        this.index=index;
    }

    public String toString(){
        if(header.type instanceof IRPointerType)
            if(((IRPointerType)header.type).baseType instanceof IRClassType)
                return target+" = getelementptr inbounds "+((IRPointerType)header.type).baseType+", "+header.type+" "+header+", i32 0, "+index.type+" "+index;
            else
                return target+" = getelementptr inbounds "+((IRPointerType)header.type).baseType+", "+header.type+" "+header+", "+index.type+" "+index;
        else
            throw new compilerError("getElementPtr header is not a pointer",new position(0,0));
    }

    @Override
    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
