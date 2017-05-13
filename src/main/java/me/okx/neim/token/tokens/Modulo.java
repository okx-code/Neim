package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.Vectorisable;
import me.okx.neim.var.VarInteger;

public class Modulo extends Vectorisable implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {
        System.out.print(a.getValue() + "%" + b.getValue() + " == ");
        VarInteger val = a.modulo(b);
        System.out.println(val);
        return new NStackBuilder(val).build();
    }
}
