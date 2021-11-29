package MIR.IRScope;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class IRScopeBase {
    public IRScopeBase parentsScope;
    private int cnt;

    public int regCnt(){
        int id=cnt;
        cnt++;
        return id;
    }

    public IRScopeBase(IRScopeBase parentsScope,int cnt){
        this.parentsScope=parentsScope;
        this.cnt=cnt;
    }
}
