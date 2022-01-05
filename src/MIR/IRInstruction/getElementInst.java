package MIR.IRInstruction;

import MIR.IRtype.IRArrayType;
import MIR.IRtype.IRPointerType;
import MIR.Operand.IROperand;
import MIR.Operand.Register;
import Util.error.compilerError;
import Util.position;

public class getElementInst extends Instruction{
    Register target;
    IROperand header;
    IROperand index;

    public getElementInst(Register target,IROperand header,IROperand index){
        this.target=target;
        this.header=header;
        this.index=index;
    }

    public String toString(){
        if(header.type instanceof IRPointerType)
            return target+" = getelementptr inbounds "+((IRPointerType)header.type).baseType+", "+header.type+" "+header+", "+index.type+" "+index;
        else
            throw new compilerError("getElementPtr header is not a pointer",new position(0,0));
    }
}
