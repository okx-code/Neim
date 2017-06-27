package me.okx.neim.token.tokens.twochar;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.TwoChar;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

import java.util.Arrays;
import java.util.List;

public class ThreeDigitNumber implements TwoChar {
    private int offset;

    public ThreeDigitNumber(int offset) {
        this.offset = offset;
    }

    @Override
    public NStack twoChar(NStack stack, String theChar, TokenManager tm) {
        List<String> codePage = Arrays.asList(Util.getCodepage());
        stack.push(new VarInteger(codePage.indexOf(theChar) + offset));
        return stack;
    }
}
