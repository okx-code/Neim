package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base255 implements Special {
    @Override
    public NStack special(NStack stack, String value, TokenManager te) {
        value = new StringBuilder(value).reverse().toString();

        int pow = 0;
        BigInteger total = BigInteger.ZERO;

        List<String> codepage = new ArrayList<>(Arrays.asList(Util.getCodepage()));
        codepage.remove(")");

        String actual = "";

        BigInteger _255 = BigInteger.valueOf(255);

        for(char c : value.toCharArray()) {
            actual += c;

            if(!codepage.contains(actual)) {
                continue;
            }

            int index = codepage.indexOf(actual);

            total = total.add(_255.pow(pow).multiply(BigInteger.valueOf(index)));

            pow++;

            actual = "";
        }

        stack.push(new VarInteger(total));

        return stack;
    }
}
