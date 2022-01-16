package Backend;

import Backend.ASMOperand.ASMReg;
import Backend.ASMOperand.VirtualReg;
import Util.error.compilerError;
import Util.position;

import java.util.LinkedHashMap;
import java.util.Map;

public class StackManager {
    public LinkedHashMap<VirtualReg,Integer> RegMap;    //<reg,addr>
    public LinkedHashMap<Integer,Integer> allocaMap;//<addr,size>
    int currentHeader;

    public StackManager(){
        RegMap=new LinkedHashMap<>();
        allocaMap=new LinkedHashMap<>();
        currentHeader=0;
    }

    public int alloca(int size){
        int addr=currentHeader;
        currentHeader+=size;
        allocaMap.put(addr,size);
        return addr;
    }

    public int assignReg(VirtualReg vr){
        RegMap.put(vr,currentHeader);
        int addr=currentHeader;
        currentHeader+=4;
        return addr;
    }

    public Integer calSize(){
        int totalSize=0;
        totalSize+=RegMap.size()*4;
        for (Map.Entry<Integer, Integer> entry : allocaMap.entrySet()) {
            Integer size = entry.getValue();
            totalSize += size;
        }
        return totalSize;
    }
}
