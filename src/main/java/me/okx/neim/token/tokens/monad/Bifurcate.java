package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Bifurcate implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        Object b = a;
        if(a instanceof IntList) {
            b = ((IntList) ((IntList) a).clone()).reverse();
        } else if(a instanceof VarInteger) {
            b = ((VarInteger) a).clone().chars().reverse().join();
        }

        return new NStackBuilder(a).add(b).build();
    }
}
