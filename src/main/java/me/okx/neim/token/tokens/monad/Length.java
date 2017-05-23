package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Length implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        long size = 0;
        if(a instanceof VarInteger) {
            size = String.valueOf(((VarInteger) a).getValue()).length();
        } else if(a instanceof IntList) {
            size = ((IntList) a).size();
        }
        return new NStackBuilder(new VarInteger(size)).build();
    }
}
