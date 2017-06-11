package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntList;
import me.okx.neim.var.InfiniteList;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class IndexOf extends VectorisableDyadIntList implements Dyad<VarInteger, IntList> {

    @Override
    public NStack dyad(VarInteger a, IntList b) {
        for(int i = 0; i < b.size() ; i++) {
            VarInteger v = b.get(i);
            if(b instanceof InfiniteList && v.getBigIntegerValue().compareTo(a.getBigIntegerValue()) > 0) {
                return new NStackBuilder(new VarInteger(-1)).build();
            }

            if(a.equals(v)) {
                return new NStackBuilder(new VarInteger(i)).build();
            }

            i++;
        }
        return new NStackBuilder(new VarInteger(-1)).build();
    }
}
