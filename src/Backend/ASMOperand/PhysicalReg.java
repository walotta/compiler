package Backend.ASMOperand;

import Backend.ASMLabel;

public class PhysicalReg extends ASMReg{
    int phyId;

    public PhysicalReg(int phyId){
        this.phyId=phyId;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return phyId==((PhysicalReg) obj).phyId;
    }

    @Override
    public int hashCode(){
        return phyId;
    }

    @Override
    public String toString(){
        if(phyId==0)
            return "zero";
        else if(phyId==1)
            return "ra";
        else if(phyId==2)
            return "sp";
        else if(phyId==3)
            return "gp";
        else if(phyId==4)
            return "tp";
        else if(phyId>=5&&phyId<=7)
            return "t"+(phyId-5);
        else if(phyId>=8&&phyId<=9)
            return "s"+(phyId-8);
        else if(phyId>=10&&phyId<=17)
            return "a"+(phyId-10);
        else if(phyId>=18&&phyId<=27)
            return "s"+(phyId-16);
        else
            return "t"+(phyId-25);
    }
}
