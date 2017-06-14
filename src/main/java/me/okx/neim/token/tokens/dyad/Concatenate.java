package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

public class Concatenate implements Dyad<Object, Object> {

    @Override
    public NStack dyad(Object a, Object b) {
        VarInteger va = Util.toVarInteger(a);
        VarInteger vb = Util.toVarInteger(b);

        return new NStackBuilder(new VarInteger(va.toString() + vb.toString())).build();
    }
}