package me.okx.neim.var;

import java.util.ArrayList;

public class IntList extends ArrayList<VarInteger> {
    public IntList(ArrayList<VarInteger> arr) {
        this.addAll(arr);
    }

    public IntList() {

    }

    public void addInt(int n) {
        this.add(new VarInteger(n));
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        for (int k = 0; k < this.size(); k++) {
            if (k != 0) {
                strb.append(" ");
            }
            strb.append(this.get(k).getValue());
        }
        return strb.toString();
    }

    private IntList setThisTo(IntList that) {
        this.clear();
        this.addAll(that);
        return this;
    }

    public IntList uniquify() {
        IntList ret = new IntList();
        for (VarInteger v : this) {
            if (!ret.contains(v)) {
                ret.add(v);
            }
        }
        return setThisTo(ret);
    }

    public VarInteger product() {
        VarInteger ret = new VarInteger(1);
        for(VarInteger v : this) {
            ret.multiply(v);
        }
        return ret;
    }

    public VarInteger sum() {
        VarInteger ret = new VarInteger(0);
        for(VarInteger v : this) {
            ret.add(v);
        }
        return ret;
    }
}
