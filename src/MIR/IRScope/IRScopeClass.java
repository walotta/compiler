package MIR.IRScope;

public class IRScopeClass extends IRScopeBase{
    String className;

    public IRScopeClass(IRScopeBase parentsScope,String className){
        super(parentsScope);
        cnt=0;
        this.className=className;
    }
}
