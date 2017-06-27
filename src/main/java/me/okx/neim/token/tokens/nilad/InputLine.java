package me.okx.neim.token.tokens.nilad;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;

public class InputLine implements Manipulator {
    private int line;

    public InputLine(int line) {
        this.line = line;
    }

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        stack.push(tm.getInput().getSomething(line));
        return stack;
    }
}
