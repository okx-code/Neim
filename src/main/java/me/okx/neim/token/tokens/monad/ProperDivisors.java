package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class ProperDivisors implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        IntList divisors = a.getDivisors();
        if(divisors.size() > 0) {
            divisors.remove(divisors.size() - 1);
        }

        return new NStackBuilder(divisors).build();
    }
}
