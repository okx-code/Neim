package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.Vectorisable;
import me.okx.neim.var.VarInteger;

public class Equal extends Vectorisable implements Dyad<Object, Object> {

    @Override
    public NStack dyad(Object a, Object b) {
        return new NStackBuilder(a.equals(b) ? new VarInteger(1) : new VarInteger(0)).build();
    }
}
