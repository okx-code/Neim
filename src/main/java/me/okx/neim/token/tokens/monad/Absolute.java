package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.token.types.vectorisable.Vectorisable;
import me.okx.neim.var.VarInteger;

public class Absolute extends Vectorisable implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        VarInteger val;
        if(a.getValue() >= 0) {
            val = a;
        } else {
            val = a.multiply(new VarInteger(-1));
        }
        return new NStackBuilder(val).build();
    }
}
