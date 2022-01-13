package MIR;

public class IRBaseCounter {
    private int cnt;
    public IRBaseCounter(){
        cnt=0;
    }

    public int count(){
        int ret=cnt;
        cnt+=1;
        return ret;
    }

    public int current(){
        return cnt;
    }
}
