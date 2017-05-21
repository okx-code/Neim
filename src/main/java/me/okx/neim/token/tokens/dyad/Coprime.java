package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.var.VarInteger;

public class Coprime implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        return new NStackBuilder(a.coprime(b)).build();
    }
}
