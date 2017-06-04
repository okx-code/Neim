package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToBase255 implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        long v = a.getValue();
        int digits = 0;
        for(int i = 0; ; i++) {
            if(Math.pow(255, i) > v) {
                digits = i;
                break;
            }
        }
        StringBuilder result = new StringBuilder();

        List<String> codepage = new ArrayList<>(Arrays.asList(Util.getCodepage()));
        codepage.remove(")");

        digits--;
        for(int i = digits; i >= 0; i--) {
            int times = (int) Math.floor(v/Math.pow(255,i));
            v -= Math.pow(255, i) * times;
            result.append(codepage.get(times));
        }
        return new NStackBuilder(result.toString()).build();
    }
}
