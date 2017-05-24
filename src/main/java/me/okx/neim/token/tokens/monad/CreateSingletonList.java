package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

public class CreateSingletonList implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        NStackBuilder nsb = new NStackBuilder();
        if(a instanceof VarInteger) {
            nsb.add(Util.createSingletonList((VarInteger) a));
        }
        return nsb.build();
    }
}
