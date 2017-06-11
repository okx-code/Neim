package me.okx.neim.token.tokens.manipulator;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;

public class Terminate implements Manipulator {

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        tm.finish = true;
        return stack;
    }
}
