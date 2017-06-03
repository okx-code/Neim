package me.okx.neim.token.tokens.twotoken;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.TwoToken;

public class Assign implements TwoToken {

    @Override
    public NStack twoToken(NStack stack, String token, TokenManager tm) {
        tm.registerVariable(token, stack.pop());
        return tm.getStack();
    }
}
