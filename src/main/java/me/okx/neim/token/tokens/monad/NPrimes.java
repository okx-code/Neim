package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class NPrimes implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        IntList primes = new IntList();
        for(long i = 1; i <= a.getValue(); i++) {
            primes.add(new VarInteger(i).nthPrime());
        }
        return new NStackBuilder(primes).build();
    }
}
