package Util.Type;

public class arrayType extends Type{
    public Type type;
    public int dim;

    public arrayType(Type type,int dim){
        super(types.Array);
        this.type=type;
        this.dim=dim;
    }

    @Override
    public int dim(){
        return dim;
    }
}
