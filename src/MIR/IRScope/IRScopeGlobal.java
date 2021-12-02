package MIR.IRScope;

import MIR.Operand.globalVariable;

import java.util.LinkedHashMap;

public class IRScopeGlobal extends IRScopeBase{

    public void insertGlobalVar(LinkedHashMap<String, globalVariable> globalVars){
        renameTable.putAll(globalVars);
    }

    public IRScopeGlobal(IRScopeBase parentsScope){
        super(parentsScope);
        cnt=0;
        stackLayer=0;
    }
}
