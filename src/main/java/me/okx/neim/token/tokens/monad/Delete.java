package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;

public class Delete implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        return new NStackBuilder().build();
    }
}
