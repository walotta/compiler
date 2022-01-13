package MIR.Operand;

import MIR.IRtype.IRLabelType;

public class Label extends IROperand{
    int id;
    String name;

    public Label(int id){
        super(new IRLabelType());
        this.id=id;
        this.name=null;
    }

    public Label(String name){
        super(new IRLabelType());
        this.id=-1;
        this.name=name;
    }

    @Override
    public String toString(){
        if(id==-1){
            return "%"+name;
        }else{
            return "%"+id;
        }
    }

    public String printLabel(){
        if(id==-1){
            return name+":";
        }else{
            return id+":";
        }
    }

    public String getLabel(){
        if(id==-1){
            return name;
        }else{
            return Integer.toString(id);
        }
    }
}
