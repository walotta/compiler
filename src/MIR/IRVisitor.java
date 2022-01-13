package MIR;

import MIR.IRInstruction.*;
import MIR.Operand.StringConstant;
import MIR.Operand.globalVariable;

public interface IRVisitor {
    Object visit(Module it);

    Object visit(Function it);
    Object visit(ClassUnit it);
    Object visit(globalVariable it);
    Object visit(StringConstant it);

    Object visit(BasicBlock it);

    Object visit(allocaInst it);
    Object visit(binaryInst it);
    Object visit(bitcastInst it);
    Object visit(brInst it);
    Object visit(callInst it);
    Object visit(compareInst it);
    Object visit(getElementInst it);
    Object visit(jumpInst it);
    Object visit(loadInst it);
    Object visit(retInst it);
    Object visit(storeInst it);
}
