package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;

public class Sum implements Monad<IntList> {

    @Override
    public NStack monad(IntList a) {
        return new NStackBuilder(a.sum()).build();
    }
}
