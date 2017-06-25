package me.okx.neim.token.tokens.manipulator;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;

public class SetFirstTwoRecurValues implements Manipulator {

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        Object one = stack.pop();
        Object zero = stack.pop();

        tm.setRecurValue(1, one);
        tm.setRecurValue(0, zero);

        return stack;
    }
}
