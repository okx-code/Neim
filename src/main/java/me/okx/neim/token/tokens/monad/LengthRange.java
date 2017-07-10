package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;

public class LengthRange implements Monad<IntList> {

    @Override
    public NStack monad(IntList a) {
        return new NStackBuilder(Util.irange(a.size())).build();
    }
}
