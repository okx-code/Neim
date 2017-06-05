package me.okx.neim.token.types;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;

public interface Special extends Token {
    NStack special(NStack stack, String value, TokenManager te);
}
