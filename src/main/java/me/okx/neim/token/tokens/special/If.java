package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class If implements Special {
    @Override
    public NStack special(NStack stack, String value, TokenManager _tm) {
        Object top = stack.pop();
        boolean a;
        if(top instanceof VarInteger) {
            a = ((VarInteger) top).getValue() == 1;
        } else {
            a = ((IntList) top).contains(new VarInteger(1));
        }
        String program;
        if(!a) {
            if(value.contains("#")) {
                program = value.split("\\#", 2)[1];
            } else {
                return stack;
            }
        } else {
            program = value;
        }
        TokenManager tm = new TokenManager();
        tm.getInput().setInputStream(stack.getInput().getInputStream());
        tm.getInput().setInputs(stack.getInput().getInputs());
        tm.getStack().addAll(stack);
        tm.registerTokens(_tm.getThetaValue(), _tm.getIndex());
        tm.handleTokens(program);
        stack.clear();
        stack.addAll(tm.getStack());

        _tm.finish = tm.isFinished();

        return stack;
    }
}
