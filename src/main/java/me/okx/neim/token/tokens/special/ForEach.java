package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.token.types.SpecialData;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class ForEach implements Special {

    @Override
    public NStack special(SpecialData data) {
        NStack stack = data.getStack();
        String value = data.getValue();
        Object top = stack.pop();
        IntList a;
        if(top instanceof VarInteger) {
            a = Util.range(((VarInteger) top).getValue());
        } else {
            a = (IntList) top;
        }
        TokenManager tm;
        IntList finished = new IntList();
        for(VarInteger var : a) {
            tm = new TokenManager();
            System.out.println("Current input stream: " + tm.getInput().getInputStream().toString());
            System.out.println("Setting to new input stream: " + stack.getInput().getInputStream().toString());
            tm.getInput().setInputStream(stack.getInput().getInputStream());
            System.out.println("New input stream: " + tm.getInput().getInputStream().toString());
            tm.getStack().push(var);
            tm.registerTokens(var.getValue());
            tm.handleTokens(value);
            finished.add((VarInteger) tm.getStack().pop());
        }
        stack.add(finished);
        return stack;
    }
}
