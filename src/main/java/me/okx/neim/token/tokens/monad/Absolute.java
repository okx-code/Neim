package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.token.types.vectorisable.Vectorisable;
import me.okx.neim.var.VarInteger;

public class Absolute extends Vectorisable implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        return new NStackBuilder(a.abs()).build();
    }
}
