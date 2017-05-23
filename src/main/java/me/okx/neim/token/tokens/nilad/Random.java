package me.okx.neim.token.tokens.nilad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.var.VarInteger;

public class Random implements Nilad {

    @Override
    public NStack nilad() {
        java.util.Random r = new java.util.Random();
        return new NStackBuilder(r.nextBoolean() ? new VarInteger(1) : new VarInteger(0)).build();
    }
}
