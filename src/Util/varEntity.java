package Util;

import Util.Type.Type;

public class varEntity{
    public String name;
    public Type type;
    public boolean isGlobal,isMember;

    public varEntity(String name,Type type,boolean isGlobal){
        this.name=name;
        this.type=type;
        this.isGlobal=isGlobal;
        this.isMember=false;
    }
}
