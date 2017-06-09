package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.var.VarInteger;

public class nTimesDo implements Special {

    @Override
    public NStack special(NStack stack, String value, TokenManager te) {
        TokenManager tm = new TokenManager();
        long v = ((VarInteger) stack.pop()).getValue();
        NStack clone = (NStack) stack.clone();
        for(long i = 0; i < v; i++) {
            tm = new TokenManager(te.getInput());
            for(Object o : clone) {
                tm.getStack().push(o);
            }
            tm.registerTokens(100);
            tm.handleTokens(value);
            for(Object o : tm.getStack()) {
                stack.push(o);
            }
            if(tm.isFinished()) {
                break;
            }
        }
        te.setFinished(tm.isFinished());
        return stack;
    }
}
