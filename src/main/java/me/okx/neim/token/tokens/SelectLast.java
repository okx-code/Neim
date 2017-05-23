package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadListInt;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class SelectLast extends VectorisableDyadListInt implements Dyad<IntList, VarInteger> {

    @Override
    public NStack dyad(IntList a, VarInteger b) {
        IntList c = new IntList();
        for(int i = 0; i < b.getValue(); i++) {
            c.add(a.get(a.size()-i-1));
        }
        c.reverse();
        return new NStackBuilder(c).build();
    }
}
