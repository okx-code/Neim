package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntInt;
import me.okx.neim.var.VarInteger;

import java.math.BigInteger;

public class Power extends VectorisableDyadIntInt implements Dyad<VarInteger, VarInteger> {

    @Override
    public NStack dyad(VarInteger a, VarInteger b) {

        return new NStackBuilder(
                new VarInteger(pow(a.getBigIntegerValue(), b.getBigIntegerValue()))
        ).build();
    }

    // recursion is bad but who cares
    private BigInteger pow(BigInteger base, BigInteger power) {
        if(power.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
        return base.multiply(pow(base, power.subtract(BigInteger.ONE)));
    }
}
