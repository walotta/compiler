package MIR;

import MIR.IRtype.IRBaseType;

public record IRMember(IRBaseType memberType, int memberCnt) {

    public int size() {
        return memberType.size();
    }

    @Override
    public String toString() {
        return memberType.toString();
    }
}
