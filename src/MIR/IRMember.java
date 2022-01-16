package MIR;

import MIR.IRtype.IRBaseType;

import java.util.Objects;

public final class IRMember {
    private final IRBaseType memberType;
    private final int memberCnt;

    public IRMember(IRBaseType memberType, int memberCnt) {
        this.memberType = memberType;
        this.memberCnt = memberCnt;
    }

    public int size() {
        return memberType.size();
    }

    @Override
    public String toString() {
        return memberType.toString();
    }

    public IRBaseType memberType() {
        return memberType;
    }

    public int memberCnt() {
        return memberCnt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (IRMember) obj;
        return Objects.equals(this.memberType, that.memberType) &&
                this.memberCnt == that.memberCnt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberType, memberCnt);
    }

}
