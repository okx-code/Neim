package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.*;

public class Sort implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        Object finished = null;
        if(a instanceof IntList) {
            IntList ia = (IntList) a;
            Collections.sort(ia, (Comparator<VarInteger>) (o1, o2) -> (int) o1.clone().subtract(o2.clone()).getValue());
            finished = ia;
        } else if(a instanceof VarInteger) {
            char[] chars = a.toString().toCharArray();
            Arrays.sort(chars);
            finished = new VarInteger(new String(chars));
        }
        return new NStackBuilder(finished).build();
    }
}
