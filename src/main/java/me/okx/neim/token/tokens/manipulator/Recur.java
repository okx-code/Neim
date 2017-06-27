package me.okx.neim.token.tokens.manipulator;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;

public class Recur implements Manipulator {

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        /*List<String> inputs = new ArrayList<>();
        inputs.add(String.valueOf(stack.pop()));

        InputUtil iu = new InputUtil();
        iu.setInputs(inputs);

        TokenManager te = new TokenManager(iu, tm.getSuperProgram());
        te.setCounter(tm.getCounter() + 1);
        te.registerTokens(100);

        te.handleTokens(tm.getSuperProgram());

        stack.push(new VarInteger(te.getCounter()));*/

        return stack;
    }
}
