package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class ListConstructor implements Special {

    @Override
    public NStack special(NStack stack, String value, TokenManager _tm) {

        TokenManager te = new TokenManager(stack.getInput());
        te.registerTokens(100);
        te.handleTokens(value);

        _tm.setFinished(te.isFinished());

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
