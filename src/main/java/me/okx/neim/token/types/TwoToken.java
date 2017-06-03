package me.okx.neim.token.types;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;

public interface TwoToken extends Token {
    NStack twoToken(NStack stack, String token, TokenManager tm);
}
