package me.okx.neim.token.tokens.manipulator;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;

public class DeleteAllUnderneath implements Manipulator {

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        return new NStackBuilder(stack.pop()).build();
    }
}
