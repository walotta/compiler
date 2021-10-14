package Util.error;
import Util.position;

abstract public class error extends RuntimeException {
    private position pos;
    private String msg;

    public error(String msg,position pos){
        this.msg=msg;
        this.pos=pos;
    }

    public String toString(){
        return msg+":"+pos.toString();
    }
}