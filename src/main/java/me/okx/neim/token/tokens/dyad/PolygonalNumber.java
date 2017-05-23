package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntInt;
import me.okx.neim.var.VarInteger;

public class PolygonalNumber extends VectorisableDyadIntInt implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        long n = b.getValue();
        long s = a.getValue();
        long result = (n*n*(s-2)-n*(s-4))/2;
        return new NStackBuilder(new VarInteger(result)).build();
    }
}
