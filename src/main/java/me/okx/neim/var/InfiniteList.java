package me.okx.neim.var;

import java.util.*;

public class InfiniteList extends IntList {
    protected List<Long> internalList = new ArrayList<>();

    @Override
    public int size() {
        return Integer.MAX_VALUE;
    }

    @Override
    public VarInteger get(int index) {
        if(internalList.size() > index) {
            return new VarInteger(internalList.get(index));
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        VarInteger get = get(i);
        while(true) {
            sb.append(get);
            i++;
            get = get(i);
            if(get.getValue() < 0) {
                break;
            } else {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}