package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.var.VarInteger;

public class Repeat implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        String as = a.toString();
        StringBuilder result = new StringBuilder();
        for(long i = 0; i < b.getValue(); i++) {
            result.append(as);
        }
        return new NStackBuilder(new VarInteger(result.toString())).build();
    }
}
