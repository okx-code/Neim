package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntInt;
import me.okx.neim.var.VarInteger;

public class AbsoluteSubtract extends VectorisableDyadIntInt implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        return new NStackBuilder(a.subtract(b).abs()).build();
    }
}
