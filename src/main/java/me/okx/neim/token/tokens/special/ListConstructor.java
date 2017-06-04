package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.token.types.SpecialData;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class ListConstructor implements Special {

    @Override
    public NStack special(SpecialData data) {
        String value = data.getValue();
        NStack stack = data.getStack();

        TokenManager te = new TokenManager(stack.getInput());
        te.registerTokens(100);
        te.handleTokens(value);

        NStack newStack = te.getStack();

        IntList l = new IntList();

        for(Object o : newStack) {
            if(o instanceof IntList) {
                l.addAll((IntList) o);
            } else if(o instanceof VarInteger) {
                l.add((VarInteger) o);
            }
        }

        return new NStackBuilder().addAll(stack).add(l).build();
    }
}
