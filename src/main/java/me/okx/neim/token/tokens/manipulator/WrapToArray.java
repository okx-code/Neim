package me.okx.neim.token.tokens.manipulator;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class WrapToArray implements Manipulator {

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        IntList l = new IntList();
        while(stack.size() > 0) {
            Object o = stack.pop();
            if(o instanceof IntList) {
                l.addAll((IntList) o);
            } else if(o instanceof VarInteger) {
                l.add((VarInteger) o);
            }
        }
        return new NStackBuilder().addAll(stack).add(l).build();
    }
}
