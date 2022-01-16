package Backend;

import Backend.ASMInst.ASMMemoryInst;
import Backend.ASMOperand.*;

import java.util.ArrayList;
import java.util.HashMap;

public class simpleRegDist {
    ASMModule oriModule;
    ASMFunction currentFunction;
    PhysicalReg rdReg=new PhysicalReg(5);
    PhysicalReg rs1Reg=new PhysicalReg(6);
    PhysicalReg rs2Reg=new PhysicalReg(7);
    private final PhysicalReg stackHeaderReg=new PhysicalReg(2);
    HashMap<PhysicalReg,VirtualReg> regDict=new HashMap<>();

    public simpleRegDist(ASMModule oriModule){
        this.oriModule=oriModule;
    }

    private ASMOperandBase loadToPhyReg(ASMOperandBase ori,ASMBlock currentBlock,PhysicalReg target){
        if(ori instanceof VirtualReg){
            int addr;
            if(currentFunction.stackManager.RegMap.containsKey(ori)){
                addr=currentFunction.stackManager.RegMap.get(ori);
            }else{
                addr=currentFunction.stackManager.assignReg((VirtualReg) ori);
            }
            currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.lw,target,stackHeaderReg,new Immediate(addr)));
            regDict.put(target,(VirtualReg) ori);
            return target;
        }else {
            regDict.put(target,null);
            return ori;
        }
    }

    private void saveToMemory(ASMOperandBase target,ASMBlock currentBlock){
        if(target instanceof PhysicalReg){
            VirtualReg source=regDict.get(target);
            if(source!=null){
                int addr=currentFunction.stackManager.RegMap.get(source);
                currentBlock.insts.add(new ASMMemoryInst(ASMMemoryInst.op.sw,(PhysicalReg)target,stackHeaderReg,new Immediate(addr)));
            }
        }
    }

    public ASMModule run(){
        ASMModule retModule=new ASMModule();
        retModule.globalVars=oriModule.globalVars;
        oriModule.funcs.forEach((funcName,func)->{
            retModule.funcs.put(funcName,visit(func));
        });
        //deal with FuncStackSize
        HashMap<String,Integer> funcSizeMap=new HashMap<>();
        for(var func:retModule.funcs.values()){
            funcSizeMap.put(func.funcName,func.stackManager.calSize());
        }
        for(var func:retModule.funcs.values()){
            for(var block:func.blocks){
                for(var inst:block.insts){
                    if(inst.rd instanceof FuncStackSize){
                        ((FuncStackSize) inst.rd).resize(funcSizeMap.get(((FuncStackSize) inst.rd).funcName));
                    }
                    if(inst.rs1 instanceof FuncStackSize){
                        ((FuncStackSize) inst.rs1).resize(funcSizeMap.get(((FuncStackSize) inst.rs1).funcName));
                    }
                    if(inst.rs2 instanceof FuncStackSize){
                        ((FuncStackSize) inst.rs2).resize(funcSizeMap.get(((FuncStackSize) inst.rs2).funcName));
                    }
                }
            }
        }
        return retModule;
    }

    public ASMFunction visit(ASMFunction oriFunc){
        currentFunction=oriFunc;
        ArrayList<ASMBlock> newBlocks=new ArrayList<>();
        oriFunc.blocks.forEach(block->{
            newBlocks.add(visit(block));
        });
        oriFunc.blocks=newBlocks;
        return currentFunction;
    }

    public ASMBlock visit(ASMBlock oriBlock){
        //deal with VirtualReg
        ASMBlock retBlock=new ASMBlock(oriBlock.label);
        oriBlock.insts.forEach(inst->{
            inst.rd=loadToPhyReg(inst.rd,retBlock,rdReg);
            inst.rs1=loadToPhyReg(inst.rs1,retBlock,rs1Reg);
            inst.rs2=loadToPhyReg(inst.rs2,retBlock,rs2Reg);
            retBlock.insts.add(inst);
            saveToMemory(inst.rd,retBlock);
            saveToMemory(inst.rs1,retBlock);
            saveToMemory(inst.rs2,retBlock);
        });
        return retBlock;
    }
}
