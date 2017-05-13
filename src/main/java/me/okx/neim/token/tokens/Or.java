package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.var.VarInteger;

public class Or implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        return new NStackBuilder(new VarInteger(
                (a.getValue() == 1) || (b.getValue() == 1) ? 1 : 0
        )).build();
    }
}
