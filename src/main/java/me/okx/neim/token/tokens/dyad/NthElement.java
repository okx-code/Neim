package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadListInt;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class NthElement extends VectorisableDyadListInt implements Dyad<IntList, VarInteger> {

    @Override
    public NStack dyad(IntList a, VarInteger b) {
        return new NStackBuilder(a.get((int) b.getValue())).build();
    }
}
