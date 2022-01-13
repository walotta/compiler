package MIR;

public class IRCounter {
    private final IRBaseCounter labelCounter;
    private final IRBaseCounter stringCounter;
    public IRCounter(){
        labelCounter=new IRBaseCounter();
        stringCounter=new IRBaseCounter();
    }
    public int getLabelCnt(){
        return labelCounter.count();
    }
    public int getStringConstCnt(){
        return stringCounter.count();
    }
}
