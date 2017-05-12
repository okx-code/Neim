package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.util.InputUtil;

public class Input implements Nilad {

    @Override
    public NStack nilad() {
        return new NStackBuilder(InputUtil.getSomething()).build();
    }
}
