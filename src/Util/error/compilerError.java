package Util.error;

import Util.position;

public class compilerError extends error{

    public compilerError(String msg, position pos){
        super("COMPILER RUN ERROR: "+msg,pos);
    }

}
