package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntInt;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

public class GreaterThan extends VectorisableDyadIntInt implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        return new NStackBuilder(
                Util.booleanToNumber(
                        a.getBigIntegerValue().compareTo(b.getBigIntegerValue()) > 0
                )
        ).build();
    }
}
