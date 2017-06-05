package me.okx.neim.token.tokens.twotoken;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.tokens.special.ForEach;
import me.okx.neim.token.types.TwoToken;

public class ShortForEach implements TwoToken {

    @Override
    public NStack twoToken(NStack stack, String token, TokenManager tm) {
        ForEach fe = new ForEach();
        NStack newStack = fe.special(stack, token, tm);
        return newStack;
    }
}
