package Backend.ASMOperand;

public class PhysicalReg extends ASMReg{
    int phyId;

    public PhysicalReg(int phyId){
        this.phyId=phyId;
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
