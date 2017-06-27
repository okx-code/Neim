package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntList;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Contains extends VectorisableDyadIntList implements Dyad<VarInteger, IntList> {

    @Override
    public NStack dyad(VarInteger a, IntList b) {
        return new NStackBuilder(Util.booleanToNumber(b.contains(a))).build();
    }
}
