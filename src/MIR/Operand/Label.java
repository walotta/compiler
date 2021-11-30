package MIR.Operand;

public class Label extends IROperand{
    int id;
    String name;

    public Label(int id){
        super(null);
        this.id=id;
        this.name=null;
    }

    public Label(String name){
        super(null);
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
}
