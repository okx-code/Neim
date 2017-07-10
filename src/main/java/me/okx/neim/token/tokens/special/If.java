package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.math.BigInteger;

public class If implements Special {
    @Override
    public NStack special(NStack stack, String value, TokenManager _tm) {
        Object top = stack.pop();
        boolean a;
        if(top instanceof VarInteger) {
            a = ((VarInteger) top).getBigIntegerValue().compareTo(new BigInteger("1")) == 0;
        } else {
            a = ((IntList) top).contains(new VarInteger(1));
        }
        String program;
        if(!a) {
            if(value.contains("#")) {
                program = value.split("\\#", 2)[1];
            } else {
                return stack;
            }
        } else {
            program = value.split("\\#")[0];
        }
        _tm.handleTokens(program, _tm.isDebug());

        return stack;
    }
}
