package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;

public class InfiniteLoop implements Special {

    @Override
    public NStack special(NStack stack, String value, TokenManager te) {
        TokenManager tm = new TokenManager(te.getInput());
        tm.registerTokens(100);

        tm.getStack().addAll(stack);

        while(!(tm.finishSilent || tm.finish)) {
            tm.handleTokens(value);
        }

        return tm.getStack();
    }
}
