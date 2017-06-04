package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class RemoveLast implements Dyad<Object, Object> {

    @Override
    public NStack dyad(Object a, Object b) {
        IntList ret;

        if(b instanceof IntList) {
            IntList bl = (IntList) b;
            if(bl.size() > 0) {
                bl.remove(bl.size()-1);
            }
            ret = bl;
        } else {
            IntList al = (IntList) a;
            VarInteger bl = (VarInteger) b;

            for(int i = 0; i < bl.getValue(); i++) {
                if (al.size() < 1) {
                    break;
                }
                al.remove(al.size()-1);
            }

            ret = al;
        }

        return new NStackBuilder(ret).build();
    }
}
