package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;

public class nTimesDo implements Special {

    @Override
    public NStack special(NStack stack, String value, TokenManager te) {
        long v = stack.popInt().getValue();
        for(long i = 0; i < v; i++) {
            te.handleTokens(value, te.isDebug());
            if(te.isFinished()) {
                break;
            }
        }
        return stack;
    }
}
