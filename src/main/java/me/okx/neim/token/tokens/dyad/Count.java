package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntList;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Count extends VectorisableDyadIntList implements Dyad<IntList, VarInteger> {

    @Override
    public NStack dyad(IntList a, VarInteger b) {
        int count = 0;
        for(VarInteger c : a) {
            if(c.equals(b)) {
                count++;
            }
        }
        return new NStackBuilder(new VarInteger(count)).build();
    }
}
