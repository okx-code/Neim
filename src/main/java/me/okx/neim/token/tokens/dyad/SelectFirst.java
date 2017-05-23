package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadListInt;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class SelectFirst extends VectorisableDyadListInt implements Dyad<IntList, VarInteger> {

    @Override
    public NStack dyad(IntList a, VarInteger b) {
        IntList c = new IntList();
        for(int i = 0; i < b.getValue(); i++) {
            c.add(a.get(i));
        }
        return new NStackBuilder(c).build();
    }
}
