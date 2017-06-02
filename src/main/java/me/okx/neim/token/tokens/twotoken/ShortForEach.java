package me.okx.neim.token.tokens.twotoken;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.tokens.special.ForEach;
import me.okx.neim.token.types.SpecialData;
import me.okx.neim.token.types.TwoToken;

public class ShortForEach implements TwoToken {

    @Override
    public NStack twoToken(NStack stack, String token) {
        ForEach fe = new ForEach();
        NStack newStack = fe.special(new SpecialData(token, stack));
        return newStack;
    }
}
