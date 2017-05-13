package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Range implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        return new NStackBuilder(range(a.getValue())).build();
    }

    private IntList range(int a) {
        IntList list = new IntList();
        for(int i = 0; i < a; i++) {
            list.add(new VarInteger(i));
        }
        return list;
    }
}
