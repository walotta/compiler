package MIR.IRScope;

import MIR.Operand.IROperand;
import Util.error.compilerError;
import Util.position;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class IRScopeBase {
    public IRScopeBase parentsScope;
    protected int cnt;
    protected int stackLayer;

    public LinkedHashMap<String, IROperand> renameTable;

    public int getLayer(){
        return stackLayer;
    }

    public IROperand queryRename(String name){
        if(renameTable.containsKey(name))
            return renameTable.get(name);
        else
            if(parentsScope==null)
                throw new compilerError("query rename null!",new position(0,0));
            IROperand ret=parentsScope.queryRename(name);
            if(ret==null)
                throw new compilerError("query rename null!",new position(0,0));
            return ret;
    }

    public int regCnt(){
        int id=cnt;
        cnt++;
        return id;
    }

    public void copyCnt(IRScopeBase o){
        this.cnt=o.cnt;
    }

    public IRScopeBase(IRScopeBase parentsScope){
        renameTable=new LinkedHashMap<>();
        this.parentsScope=parentsScope;
        if(parentsScope==null){
            this.cnt=0;
            this.stackLayer=0;
        }
        else{
            this.cnt=parentsScope.cnt;
            this.stackLayer=parentsScope.stackLayer+1;
        }
    }
}
