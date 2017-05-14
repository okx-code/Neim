package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadntIntOrIntList;
import me.okx.neim.var.VarInteger;

public class MultipleOf extends VectorisableDyadntIntOrIntList implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        return new NStackBuilder(a.modulo(b).equals(new VarInteger(0)) ?
                new VarInteger(1) : new VarInteger(0)).build();
    }
}
