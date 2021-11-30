package MIR;

public class LabelCounter {
    private int cnt;
    public LabelCounter(){
        cnt=0;
    }
    public int getCnt(){
        int reg=cnt;
        cnt++;
        return reg;
    }
}
