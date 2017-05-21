package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.types.Nilad;

public class Nothing implements Nilad {

    @Override
    public NStack nilad() {
        return new NStack(null);
    }
}
