package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.Vectorisable;
import me.okx.neim.var.VarInteger;

public class Modulo extends Vectorisable implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        VarInteger val = a.modulo(b);
        System.out.println(val);
        return new NStackBuilder(val).build();
    }
}
