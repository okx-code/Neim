package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        Object finished = null;
        if(a instanceof IntList) {
            List<Long> vals = new ArrayList<>();
            for (VarInteger val : (IntList) a) {
                vals.add(val.getValue());
            }
            Collections.sort(vals);
            finished = new IntList(vals);
        } else if(a instanceof VarInteger) {
            char[] chars = a.toString().toCharArray();
            Arrays.sort(chars);
            finished = new VarInteger(new String(chars));
        }
        return new NStackBuilder(finished).build();
    }
}
