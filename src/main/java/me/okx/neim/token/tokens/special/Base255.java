package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.types.Special;
import me.okx.neim.token.types.SpecialData;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base255 implements Special {

    @Override
    public NStack special(SpecialData data) {
        NStack stack = data.getStack();
        String value = data.getValue();

        value = new StringBuilder(value).reverse().toString();

        int pow = 0;
        long total = 0;

        List<String> codepage = new ArrayList<>(Arrays.asList(Util.getCodepage()));
        codepage.remove(")");
        for(char c : value.toCharArray()) {
            String cc = String.valueOf(c);
            int index = codepage.indexOf(cc);

            total += Math.pow(255, pow)*index;

            pow++;
        }

        stack.push(new VarInteger(total));

        return stack;
    }
}
