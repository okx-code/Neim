package me.okx.neim.token.types;

import me.okx.neim.stack.NStack;

public interface Monad<E extends Object> extends Token {
    NStack monad(E a);
}
