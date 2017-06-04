package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;

public interface Manipulator {
    NStack manipulator(NStack stack, TokenManager tm);
}
