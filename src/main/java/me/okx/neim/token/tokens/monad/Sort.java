package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort implements Monad<IntList> {

    @Override
    public NStack monad(IntList a) {
        List<Long> vals = new ArrayList<>();
        for(VarInteger val : a) {
            vals.add(val.getValue());
        }
        Collections.sort(vals);
        return new NStackBuilder(new IntList(vals)).build();
    }
}
