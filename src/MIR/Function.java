package MIR;

import MIR.IRInstruction.allocaInst;
import MIR.IRInstruction.storeInst;
import MIR.IRScope.IRScopeFunc;
import MIR.IRtype.IRBaseType;
import MIR.IRtype.IRPointerType;
import MIR.Operand.Register;
import Util.Scope.Scope;

import java.util.*;

public class Function {
    public String funcName;
    public IRBaseType retType;
    public ArrayList<Register> paras;
    public boolean isBuiltin;
    Register retReg;

    public HashMap<String, Integer> renameMap;
    public LinkedHashMap<Integer,Register> varTable;
    public LinkedList<BasicBlock> Blocks;

    public BasicBlock entranceBlock;
    public BasicBlock retBlock;

    public void buildInit(IRScopeFunc scope){
        BasicBlock entranceBlock=new BasicBlock(scope.regCnt());
        retReg=new Register(scope.regCnt(),null,new IRPointerType(retType));
        entranceBlock.instructions.add(new allocaInst(retReg));
        entranceBlock.instructions.add(new storeInst(((IRPointerType)retReg.type).baseType.defaultValue(),retReg));
        for (Register para : paras) {
            int varId = scope.regCnt();
            renameMap.put(para.identifier, varId);
            Register targetReg = new Register(varId, para.identifier, new IRPointerType(para.type));
            varTable.put(varId, targetReg);
            entranceBlock.instructions.add(new allocaInst(targetReg));
            entranceBlock.instructions.add(new storeInst(para, targetReg));
        }
        Blocks.add(entranceBlock);
    }

    public void buildRet(IRScopeFunc scope){
        //todo
        BasicBlock retBlock=new BasicBlock(scope.regCnt());

    }

    public Function(String funcName,IRBaseType retType){
        this.funcName=funcName;
        this.retType=retType;
        this.isBuiltin=false;
        this.paras=new ArrayList<>();
        this.renameMap=new HashMap<>();
        this.varTable=new LinkedHashMap<>();
        this.Blocks=new LinkedList<>();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        StringJoiner argJoiner = new StringJoiner(",", "(", ")");
        paras.forEach(item->argJoiner.add(item.type+" "+item));
        builder.append("define ").append(retType).append(" @").append(funcName).append(argJoiner).append("{\n");
        Blocks.forEach(builder::append);
        builder.append("\n}");
        return builder.toString();
    }
}
