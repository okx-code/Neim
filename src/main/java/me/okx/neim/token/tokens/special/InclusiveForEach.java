package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.token.types.SpecialData;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.function.Function;

public class InclusiveForEach implements Special {

    @Override
    public NStack special(SpecialData data) {
        NStack stack = data.getStack();
        String value = data.getValue();
        Object top = stack.pop();
        IntList a;
        if(top instanceof VarInteger) {
            a = Util.irange(((VarInteger) top).getValue());
        } else {
            a = (IntList) top;
            for(VarInteger elem : a) {
                elem.add(new VarInteger(1));
            }
        }
        TokenManager tm;
        IntList finished = new IntList();
        for(VarInteger var : a) {
            tm = new TokenManager();
            tm.getInput().setInputStream(stack.getInput().getInputStream());
            tm.getInput().setInputs(stack.getInput().getInputs());
            tm.getStack().push(var);
            tm.registerTokens(var.getValue());
            tm.handleTokens(value);
            finished.add((VarInteger) tm.getStack().pop());
        }
        stack.add(finished);
        return stack;
    }

    public void f(Function<Integer, Integer> g) {
        g.apply(3);
    }

    public void g() {
        f(a->{int t=1;for(;a>0;a--)t*=a;return t;});
    }
}