package me.okx.neim.token.types;

import me.okx.neim.stack.NStack;

public interface Special extends Token {
    NStack special(SpecialData data);
}
