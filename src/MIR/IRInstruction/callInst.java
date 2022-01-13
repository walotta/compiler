package MIR.IRInstruction;

import MIR.Function;
import MIR.IRtype.IRVoidType;
import MIR.Operand.IROperand;
import MIR.Operand.Register;

import java.util.ArrayList;
import java.util.StringJoiner;

public class callInst extends Instruction{
    public Function toCall;
    public ArrayList<IROperand> argvs;
    public Register retReg;

    public callInst(Function toCall,Register retReg,ArrayList<IROperand> argvs){
        this.toCall=toCall;
        this.retReg=retReg;
        this.argvs=argvs;
        if(toCall.retType instanceof IRVoidType)
            retReg=null;
    }

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        if(retReg!=null){
            builder.append(retReg).append(" = ");
        }
        StringJoiner argvJoiner=new StringJoiner(",","(",")");
        argvs.forEach(argv->{argvJoiner.add(argv.type+" "+argv);});
        builder.append("call ").append(toCall.retType).append(" @").append(toCall.funcName).append(argvJoiner);
        return builder.toString();
    }
}
