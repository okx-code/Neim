package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

public class Range implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        return new NStackBuilder(Util.range(a.getValue())).build();
    }
}
