package MIR.Operand;

import MIR.IRtype.IRBaseType;

import java.util.Objects;

public class Register extends IROperand{
    public int renameId;
    public String identifier;

    public Register(int renameId,String identifier,IRBaseType type){
        super(type);
        this.renameId=renameId;
        this.identifier=identifier;
        this.type=type;
    }

    @Override
    public String toString(){
        return "%"+renameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Register register = (Register) o;
        return renameId == register.renameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(renameId);
    }
}
