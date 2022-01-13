package MIR;

import MIR.IRInstruction.*;
import MIR.Operand.IROperand;
import MIR.Operand.Label;
import MIR.Operand.Register;
import MIR.Operand.globalVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class IRForwarder {
    private IRBaseCounter counter;
    private IRBaseCounter labelCounter;
    private HashMap<String,Label> renameTag;
    private HashMap<Integer,Register> renameReg;
    private final Module ori;
    private final Module out;

    public IRForwarder(Module module){
        this.ori=module;
        this.out=new Module();
    }

    public Module forward(){
        ori.functions.forEach((name,func)->{
            out.functions.put(name,rename(func));
        });
        ori.classes.forEach((className,cla)->{
            ClassUnit cla_new=new ClassUnit(className);
            cla_new.memberVars= cla.memberVars;
            cla_new.initFunc=rename(cla.initFunc);
            cla.methods.forEach((name,func)->{
                cla_new.methods.put(name,rename(func));
            });
            out.classes.put(className,cla_new);
        });
        out.globalVars=ori.globalVars;
        out.stringConstTable=ori.stringConstTable;
        out.initFuncs=ori.initFuncs;
        return out;
    }

    private IROperand renameOperand(IROperand oriOperand){
        if(oriOperand instanceof Register && !(oriOperand instanceof globalVariable)){
            if(renameReg.containsKey(((Register)oriOperand).renameId)){
                return renameReg.get(((Register)oriOperand).renameId);
            }else{
                int id=counter.count();
                Register ret=new Register(id,((Register)oriOperand).identifier,oriOperand.type);
                renameReg.put(((Register)oriOperand).renameId,ret);
                return ret;
            }
        }else
            return oriOperand;
    }

    private Label renameLabel(Label oriLabel){
        return new Label("label."+oriLabel.getLabel());
//        if(renameTag.containsKey(oriLabel.getLabel()))
//            return renameTag.get(oriLabel.getLabel());
//        else{
//            Label ret=new Label("label."+labelCounter.count());
//            renameTag.put(oriLabel.getLabel(),ret);
//            return ret;
//        }
    }

    public Function rename(Function oriFunc){
        if(oriFunc.Blocks.isEmpty())
            return oriFunc;
        Function newFunc=new Function(oriFunc.funcName, oriFunc.retType);
        newFunc.paras=oriFunc.paras;
        newFunc.isBuiltin=oriFunc.isBuiltin;
        newFunc.ExtendMsg= oriFunc.ExtendMsg;
        counter=new IRBaseCounter();
        labelCounter=new IRBaseCounter();
        renameReg=new HashMap<>();
        renameTag=new HashMap<>();
        newFunc.paras.forEach(para->{
            renameReg.put(para.renameId,new Register(counter.count(),para.identifier,para.type));
        });
//        Label allocaLabel=new Label("label."+labelCounter.count());
        Label allocaLabel=new Label("allocaLabel");
        BasicBlock allocaBlock=new BasicBlock(allocaLabel);
        oriFunc.Blocks.forEach(block->{
            for (Instruction inst : block.instructions) {
                if (inst instanceof allocaInst) {
                    Register newReg = new Register(counter.count(), ((allocaInst) inst).target.identifier, ((allocaInst) inst).target.type);
                    allocaInst newInst = new allocaInst(newReg, ((allocaInst) inst).number);
                    allocaBlock.instructions.add(newInst);
                    renameReg.put(((allocaInst) inst).target.renameId, newReg);
                }
            }
        });
        for (BasicBlock block : oriFunc.Blocks) {
            Label newLabel = renameLabel(block.label);
            BasicBlock newBlock = new BasicBlock(newLabel);
            renameTag.put(block.label.getLabel(), newLabel);
            for (Instruction inst : block.instructions) {
                Instruction newInst = null;
                if (inst instanceof binaryInst) {
                    IROperand left = renameOperand(((binaryInst) inst).leftOperand);
                    IROperand right = renameOperand(((binaryInst) inst).rightOperand);
                    IROperand target = renameOperand(((binaryInst) inst).target);
                    newInst = new binaryInst(((binaryInst) inst).type, left, right, (Register) target);
                } else if (inst instanceof bitcastInst) {
                    IROperand target = renameOperand(((bitcastInst) inst).target);
                    IROperand source = renameOperand(((bitcastInst) inst).source);
                    newInst = new bitcastInst(source, (Register) target);
                } else if (inst instanceof brInst) {
                    IROperand cond = renameOperand(((brInst) inst).cond);
                    Label trueLabel = renameLabel(((brInst) inst).trueLabel);
                    Label falseLabel = renameLabel(((brInst) inst).falseLabel);
                    newInst = new brInst(cond, trueLabel, falseLabel);
                } else if (inst instanceof callInst) {
                    ArrayList<IROperand> argvs = new ArrayList<>();
                    for (IROperand item : ((callInst) inst).argvs) {
                        argvs.add(renameOperand(item));
                    }
                    Register retReg = (Register) renameOperand(((callInst) inst).retReg);
                    newInst = new callInst(((callInst) inst).toCall, retReg, argvs);
                } else if (inst instanceof compareInst) {
                    IROperand left = renameOperand(((compareInst) inst).leftOperand);
                    IROperand right = renameOperand(((compareInst) inst).rightOperand);
                    IROperand target = renameOperand(((compareInst) inst).target);
                    newInst = new compareInst(((compareInst) inst).type, left, right, (Register) target);
                } else if (inst instanceof getElementInst) {
                    IROperand target = renameOperand(((getElementInst) inst).target);
                    IROperand header = renameOperand(((getElementInst) inst).header);
                    IROperand index = renameOperand(((getElementInst) inst).index);
                    newInst = new getElementInst((Register) target, header, index);
                } else if (inst instanceof jumpInst) {
                    Label target = renameLabel(((jumpInst) inst).target);
                    newInst = new jumpInst(target);
                } else if (inst instanceof loadInst) {
                    IROperand target = renameOperand(((loadInst) inst).target);
                    IROperand source = renameOperand(((loadInst) inst).source);
                    newInst = new loadInst((Register) target, (Register) source);
                } else if (inst instanceof retInst) {
                    IROperand toRet = renameOperand(((retInst) inst).toRet);
                    newInst = new retInst(toRet);
                } else if (inst instanceof storeInst) {
                    IROperand target = renameOperand(((storeInst) inst).target);
                    IROperand source = renameOperand(((storeInst) inst).source);
                    newInst = new storeInst(source, (Register) target);
                }
                if (newInst != null) {
                    newBlock.instructions.add(newInst);
                }
            }
            newFunc.Blocks.add(newBlock);
        }
        allocaBlock.instructions.add(new jumpInst(newFunc.Blocks.get(0).label));
        newFunc.Blocks.add(0,allocaBlock);
        if(oriFunc.retReg==null)
            newFunc.retReg=null;
        else
            newFunc.retReg=renameReg.get(oriFunc.retReg.renameId);
        return newFunc;
    }
}
