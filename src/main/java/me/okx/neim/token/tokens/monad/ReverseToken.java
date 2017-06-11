package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class ReverseToken implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        Object v;
        if(a instanceof VarInteger) {
            v = ((VarInteger) a).chars().reverse().join();
        } else {
            v = ((IntList) a).reverse();
        }
        return new NStackBuilder(v).build();
    }
}
