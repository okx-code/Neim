package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.token.types.vectorisable.Vectorisable;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class LargestDivisorUnder extends Vectorisable implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        IntList factors = a.getDivisors();
        VarInteger ret;
        if(factors.size() > 1) {
            factors.remove(factors.size() - 1);
            ret = factors.get(factors.size() - 1);
        } else {
            ret = new VarInteger(0);
        }
        return new NStackBuilder(ret).build();
    }
}
