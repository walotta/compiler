package MIR;

public class IRCounter {
    private int labelCnt;
    private int StringCnt;
    public IRCounter(){
        labelCnt=0;
        StringCnt=0;
    }
    public int getLabelCnt(){
        int ret=labelCnt;
        labelCnt++;
        return ret;
    }
    public int getStringConstCnt(){
        int ret=StringCnt;
        StringCnt++;
        return ret;
    }
}
