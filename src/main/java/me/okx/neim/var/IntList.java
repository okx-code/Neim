package me.okx.neim.var;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class IntList extends ArrayList<VarInteger> {
    public IntList(ArrayList<VarInteger> arr) {
        this.addAll(arr);
    }

    public IntList(Iterable i) {
        for(Object a : i) {
            this.add((VarInteger) a);
        }
    }

    public static IntList fromLongList(ArrayList<Long> a) {
        IntList list = new IntList();
        for(long l : a) {
            list.add(new VarInteger(l));
        }
        return list;
    }

    public IntList() {

    }

    @Override
    public VarInteger get(int index) {
        return super.get(index).clone();
    }

    public void addInt(BigInteger n) {
        this.add(new VarInteger(n));
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder("[");
        for (int k = 0; k < this.size(); k++) {
            if (k != 0) {
                strb.append(" ");
            }
            strb.append(this.get(k).getValue());
        }
        strb.append("]");
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

    public VarInteger getClosestTo(long target) {
        if (this.size() < 1)
            return new VarInteger(0);
        if (this.size() == 1) {
            return this.get(0);
        }
        long closestValue = this.get(0).getValue();
        long leastDistance = Math.abs(this.get(0).getValue() - target);
        for (int i = 0; i < this.size(); i++) {
            long currentDistance = Math.abs(this.get(i).getValue() - target);
            if (currentDistance < leastDistance) {
                closestValue = this.get(i).getValue();
                leastDistance = currentDistance;
            }
        }
        return new VarInteger(closestValue);
    }

    public VarInteger join() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < this.size(); i++) {
            if(i != 0) {
                str.append("");
            }
            str.append(this.get(i));
        }
        return new VarInteger(str.toString());
    }

    public IntList reverse() {
        Collections.reverse(this);
        return this;
    }
}
