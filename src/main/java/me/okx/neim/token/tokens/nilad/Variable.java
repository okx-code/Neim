package me.okx.neim.token.tokens.nilad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Variable implements Nilad {
    private Object value;

    public Object getValue() {
        return value;
    }

    public Variable(long value) {
        this.value = new VarInteger(value);
    }

    public Variable(Object value) {
        assert value instanceof IntList || value instanceof VarInteger;
        this.value = value;
    }

    @Override
    public NStack nilad() {
        return new NStackBuilder(value).build();
    }
}
