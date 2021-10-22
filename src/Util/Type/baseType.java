package Util.Type;
//todo noUse delete
public class baseType extends Type{
    public String name;
    public baseType(String name){
        super(name);
        this.name=name;
    }

    @Override
    public int dim(){
        return 0;
    }
}
