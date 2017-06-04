package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToBase255 implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        BigInteger v = a.getBigIntegerValue();
        BigInteger _255 = BigInteger.valueOf(255);
        int digits;
        for(int i = 0; ; i++) {
            if(_255.pow(i).compareTo(v) > 0) {
                digits = i;
                break;
            }
        }
        StringBuilder result = new StringBuilder();

        List<String> codepage = new ArrayList<>(Arrays.asList(Util.getCodepage()));
        codepage.remove(")");

        digits--;
        for(int i = digits; i >= 0; i--) {
            int times = v.divide(_255.pow(i)).intValue();
            v = v.subtract(_255.pow(i).multiply(BigInteger.valueOf(times)));
            result.append(codepage.get(times));
        }
        return new NStackBuilder(result.toString()).build();
    }
}
