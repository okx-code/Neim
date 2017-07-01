package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class EqualIgnoreTypes implements Dyad<Object, Object> {

    @Override
    public NStack dyad(Object a, Object b) {
        boolean equal;
        if(a instanceof IntList && b instanceof IntList) {
            equal = a.equals(b);
        } else {
            VarInteger intA = Util.toVarInteger(a);
            VarInteger intB = Util.toVarInteger(b);
            equal = intA.equals(intB);
        }

        return new NStackBuilder(
                Util.booleanToNumber(equal)
        ).build();
    }
}
