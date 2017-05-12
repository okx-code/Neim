package me.okx.neim.token.types;

import me.okx.neim.stack.NStack;

public interface Dyad<E extends Object, T extends Object> extends Token {
    NStack dyad(E a, T b);
}
