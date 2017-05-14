package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;

public class Join implements Monad<IntList> {

    @Override
    public NStack monad(IntList a) {
        return new NStackBuilder(a.join("")).build();
    }
}