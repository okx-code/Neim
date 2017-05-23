package me.okx.neim.var;

import java.util.*;

public class InfiniteList extends IntList {
    protected List<Integer> internalList = new ArrayList<>();

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
}