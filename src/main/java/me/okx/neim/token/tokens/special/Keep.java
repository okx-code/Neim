package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.token.types.SpecialData;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Keep implements Special {
    private int keepCondition;

    public Keep(int keepCondition) {
        this.keepCondition = keepCondition;
    }

    @Override
    public NStack special(SpecialData data) {
        NStack stack = data.getStack();
        Object top = stack.pop();
        if(top instanceof VarInteger) {
            top = Util.range(((VarInteger) top).getValue());
        }
        IntList list = (IntList) top;
        TokenManager tm;
        for(int i = 0; i < list.size(); i++) {
            VarInteger var = list.get(i).clone();
            tm = new TokenManager();
            tm.registerTokens(var.getValue());
            tm.getInput().setInputStream(stack.getInput().getInputStream());
            tm.getInput().setInputs(stack.getInput().getInputs());
            tm.getStack().push(var);
            tm.handleTokens(data.getValue());
            Object pop = tm.getStack().pop();
            if(pop instanceof VarInteger) {
                VarInteger v = (VarInteger) pop;
                if(v.getValue() != keepCondition) {
                    list.remove(i);
                    i--;
                }
            } else {
                list.remove(i);
                i--;
            }
        }
        stack.push(list);
        return stack;
    }
}
