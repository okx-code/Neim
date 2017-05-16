package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.util.InputUtil;

public class InputLine implements Nilad {
    private int line;

    public InputLine(int line) {
        this.line = line;
    }

    @Override
    public NStack nilad() {
        return new NStackBuilder(InputUtil.getSomething(line)).build();
    }
}
