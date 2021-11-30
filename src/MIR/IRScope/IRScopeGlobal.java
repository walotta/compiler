package MIR.IRScope;

public class IRScopeGlobal extends IRScopeBase{

    public void insertGlobalVar(){

    }

    public IRScopeGlobal(IRScopeBase parentsScope){
        super(parentsScope);
        cnt=0;
        stackLayer=0;
    }
}
