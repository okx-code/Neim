package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.util.InputUtil;

public class InputLine implements Nilad {
    private int line;
    private InputUtil input;

    public InputLine(int line, InputUtil input) {
        this.line = line;
        this.input = input;
    }

    @Override
    public NStack nilad() {
        return new NStackBuilder(input.getSomething(line)).build();
    }
}
