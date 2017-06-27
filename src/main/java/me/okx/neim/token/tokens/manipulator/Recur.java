package me.okx.neim.token.tokens.manipulator;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;
import me.okx.neim.var.VarInteger;

public class Recur implements Manipulator {

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        TokenManager te = new TokenManager(tm.getInput());
        te.registerTokens(100);

        VarInteger top = stack.popInt();

        te.getStack().push(top);

        te.handleTokens(tm.getCode());

        for(Object o : te.getStack()) {
            stack.push(o);
        }

        return stack;
    }
}
