package MIR;

import MIR.IRInstruction.*;
import MIR.IRScope.IRScopeBase;
import MIR.IRScope.IRScopeFunc;
import MIR.IRtype.IRBaseType;
import MIR.IRtype.IRPointerType;
import MIR.IRtype.IRVoidType;
import MIR.Operand.Label;
import MIR.Operand.Register;
import Util.Scope.Scope;

import java.util.*;

public class Function {
    public String funcName;
    public IRBaseType retType;
    public ArrayList<Register> paras;
    public boolean isBuiltin;
    public Register retReg;
    public final String retLabel="ret";
    public String ExtendMsg=null;

    public LinkedList<BasicBlock> Blocks;

    public BasicBlock genRetBlock(IRScopeBase scope){
        BasicBlock retBlock=new BasicBlock(new Label(retLabel));
        if(retReg==null)
            retBlock.pushInstruction(new retInst(null));
        else{
            Register loadRet=new Register(scope.regCnt(),null,((IRPointerType)retReg.type).baseType);
            retBlock.pushInstruction(new loadInst(loadRet,retReg));
            retBlock.pushInstruction(new retInst(loadRet));
        }
        return retBlock;
    }

    public jumpInst jumpToRet(){
        return new jumpInst(new Label(retLabel));
    }

    public void buildInit(IRScopeFunc scope,BasicBlock entranceBlock){
        if(retType instanceof IRVoidType)
            retReg=null;
        else{
            retReg=new Register(scope.regCnt(),null,new IRPointerType(retType));
            entranceBlock.pushInstruction(new allocaInst(retReg));
            entranceBlock.pushInstruction(new storeInst(((IRPointerType)retReg.type).baseType.defaultValue(),retReg));
        }
        for (Register para : paras) {
            int varId = scope.regCnt();
            Register targetReg = new Register(varId, para.identifier, new IRPointerType(para.type));
            scope.renameTable.put(para.identifier, targetReg);
            entranceBlock.pushInstruction(new allocaInst(targetReg));
            entranceBlock.pushInstruction(new storeInst(para, targetReg));
        }
    }

    public Function(String funcName,IRBaseType retType){
        this.funcName=funcName;
        this.retType=retType;
        this.isBuiltin=false;
        this.paras=new ArrayList<>();
        this.Blocks=new LinkedList<>();
    }

    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        StringJoiner argJoiner=new StringJoiner(", ", "(", ")");
        paras.forEach(item->argJoiner.add(item.type+" "+item));
        builder.append("define ");
        if(ExtendMsg!=null)
            builder.append(ExtendMsg).append(" ");
        builder.append(retType).append(" @").append(funcName).append(argJoiner).append("{\n");
        StringJoiner blockJoiner=new StringJoiner("\n");
        Blocks.forEach(item->blockJoiner.add(item.toString()));
        builder.append(blockJoiner);
        builder.append("\n}");
        return builder.toString();
    }

    public void accept(IRVisitor visitor){
        visitor.visit(this);
    }
}
