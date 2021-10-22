package Util.Scope;

import Util.position;
import Util.varEntity;

import java.util.ArrayList;

public class funcScope extends Scope{
    public ArrayList<varEntity> paras=new ArrayList<>();
    public funcScope(Scope parent){
        super(parent);
    }
    public void addParas(varEntity p, position pos){
        paras.add(p);
        defineVar(p.name,p,pos);
    }

}
