package me.okx.neim.token.types;

import me.okx.neim.stack.NStack;

public interface TwoToken extends Token {
    NStack twoToken(NStack stack, String token);
}
