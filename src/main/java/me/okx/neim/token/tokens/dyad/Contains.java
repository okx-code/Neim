package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntList;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Contains extends VectorisableDyadIntList implements Dyad<VarInteger, Object> {

    @Override
    public NStack dyad(VarInteger a, Object b) {
        Object ret;
        if(b instanceof IntList) {
            ret = Util.booleanToNumber(((IntList) b).contains(a));
        } else {
            ret = Util.booleanToNumber(b.toString().contains(a.toString()));
        }
        return new NStackBuilder(ret).build();
    }
}
