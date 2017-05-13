package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class IRange implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        return new NStackBuilder(irange(a.getValue())).build();
    }

    private IntList irange(long a) {
        IntList list = new IntList();
        for(int i = 1; i <= a; i++) {
            list.add(new VarInteger(i));
        }
        return list;
    }
}
