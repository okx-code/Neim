package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

public class XRange implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        return new NStackBuilder(Util.xrange(a.getValue(), b.getValue())).build();
    }
}
