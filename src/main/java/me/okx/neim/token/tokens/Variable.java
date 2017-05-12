package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.var.VarInteger;

public class Variable implements Nilad {
    private int value;

    public Variable(int value) {
        this.value = value;
    }

    @Override
    public NStack nilad() {
        return new NStackBuilder(new VarInteger(value)).build();
    }
}
