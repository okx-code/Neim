package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class AllEqual implements Monad<Object> {

    @Override
    public NStack monad(Object a) {
        Object ret = null;
        IntList intlist;
        if(a instanceof IntList) {
            intlist = (IntList) a;
        } else if(a instanceof VarInteger) {
            intlist = ((VarInteger) a).chars();
        } else {
            return null;
        }
        boolean allEqual = true;
        VarInteger equal = intlist.get(0);
        for(VarInteger elem : intlist) {
            if(!elem.equals(equal)) {
                allEqual = false;
                break;
            }
        }
        return new NStackBuilder(Util.booleanToNumber(allEqual)).build();
    }
}
