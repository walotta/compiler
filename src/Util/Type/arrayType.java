package Util.Type;

public class arrayType extends Type{
    public Type arrayType;
    public int dim;

    public arrayType(Type arrayType, int dim){
        super(types.Array);
        this.arrayType = arrayType;
        this.dim=dim;
    }

    @Override
    public int dim(){
        return dim;
    }
}
