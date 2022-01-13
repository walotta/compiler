package Backend;

import MIR.*;
import MIR.IRInstruction.*;
import MIR.Module;
import MIR.Operand.StringConstant;
import MIR.Operand.globalVariable;

public class InstSelect implements IRVisitor {
    private ASMModule asmModule;
    
    public InstSelect(){
        
    }

    public ASMModule run(){
        asmModule=new ASMModule();
        return asmModule;
    }

    @Override
    public Object visit(Module it){
        return null;
    }

    @Override
    public Object visit(Function it){
        return null;
    }

    @Override
    public Object visit(ClassUnit it){
        return null;
    }

    @Override
    public Object visit(globalVariable it){
        return null;
    }

    @Override
    public Object visit(StringConstant it){
        return null;
    }

    @Override
    public Object visit(BasicBlock it){
        return null;
    }

    @Override
    public Object visit(allocaInst it){
        return null;
    }

    @Override
    public Object visit(binaryInst it){
        return null;
    }

    @Override
    public Object visit(bitcastInst it){
        return null;
    }

    @Override
    public Object visit(brInst it){
        return null;
    }

    @Override
    public Object visit(callInst it){
        return null;
    }

    @Override
    public Object visit(compareInst it){
        return null;
    }

    @Override
    public Object visit(getElementInst it){
        return null;
    }

    @Override
    public Object visit(jumpInst it){
        return null;
    }

    @Override
    public Object visit(loadInst it){
        return null;
    }

    @Override
    public Object visit(retInst it){
        return null;
    }

    @Override
    public Object visit(storeInst it){
        return null;
    }
}
