package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.var.VarInteger;

public class And implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        return new NStackBuilder(
                a.getValue() == 1 && b.getValue() == 1 ? new VarInteger(1) : new VarInteger(0)
        ).build();
    }
}
