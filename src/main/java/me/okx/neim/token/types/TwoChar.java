package me.okx.neim.token.types;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;

public interface TwoChar extends Token {
    NStack twoChar(NStack stack, String theChar, TokenManager tm);
}
