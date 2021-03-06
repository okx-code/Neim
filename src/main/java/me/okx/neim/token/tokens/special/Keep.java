package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Keep implements Special {
    private int keepCondition;

    public Keep(int keepCondition) {
        this.keepCondition = keepCondition;
    }

    @Override
    public NStack special(NStack stack, String value, TokenManager _tm) {
        Object top = stack.pop();
        if(top instanceof VarInteger) {
            top = Util.range(((VarInteger) top).getValue());
        }
        IntList list = (IntList) top;
        TokenManager tm = new TokenManager();
        int j = 0;
        for(int i = 0; i < list.size(); i++) {
            VarInteger var = list.get(i).clone();
            tm = new TokenManager(_tm.getInput());
            tm.registerTokens(var.getValue(), j);
            tm.getStack().add(stack);
            tm.getStack().push(var);
            tm.handleTokens(value, _tm.isDebug());
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
            j++;
        }

        _tm.setFinished(tm.isFinished());

        stack.push(list);
        return stack;
    }
}
