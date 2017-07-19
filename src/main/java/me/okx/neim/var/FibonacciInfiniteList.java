package me.okx.neim.var;

import java.math.BigInteger;

public class FibonacciInfiniteList extends InfiniteList {
    @Override
    public VarInteger infGet(int index) {
        VarInteger v = new VarInteger();
        long a = 0;
        long b = 1;
        long tmp;
        for (int i = 0; i < index; i++) {
            tmp = a;
            a = a + b;
            b = tmp;
        }
        v.setValue(a);
        if(v.getBigIntegerValue().compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        return v;
    }
}
