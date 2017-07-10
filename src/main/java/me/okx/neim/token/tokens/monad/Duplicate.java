package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Duplicate implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        Object b = null;
        if(a instanceof IntList) {
            b = ((IntList) a).clone();
        } else if(a instanceof VarInteger) {
            b = ((VarInteger) a).clone();
        }
        return new NStackBuilder(a).add(b).build();
    }
}
