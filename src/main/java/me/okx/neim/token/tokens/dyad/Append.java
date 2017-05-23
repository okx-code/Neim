package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Append implements Dyad<Object, Object> {

    @Override
    public NStack dyad(Object a, Object b) {
        IntList result = new IntList();
        if(a instanceof VarInteger) {
            result.add((VarInteger) a);
        } else {
            result.addAll((IntList) a);
        }
        if(b instanceof VarInteger) {
            result.add((VarInteger) b);
        } else {
            result.addAll((IntList) b);
        }
        return new NStackBuilder(result).build();
    }
}
