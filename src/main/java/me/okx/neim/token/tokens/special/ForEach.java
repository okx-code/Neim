package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.function.Function;

public class ForEach implements Special {

    @Override
    public NStack special(NStack stack, String value, TokenManager _tm) {
        Object top = stack.pop();
        IntList a;
        if(top instanceof VarInteger) {
            a = Util.range(((VarInteger) top).getValue());
        } else {
            a = (IntList) top;
        }
        TokenManager tm = new TokenManager();
        IntList finished = new IntList();
        for(int i = 0; i < a.size(); i++) {
            VarInteger var = a.get(i);
            tm = new TokenManager();
            tm.getInput().setInputStream(stack.getInput().getInputStream());
            tm.getInput().setInputs(stack.getInput().getInputs());
            tm.getStack().addAll(stack);
            tm.getStack().push(var);
            tm.registerTokens(var.getValue(), i);
            tm.handleTokens(value);
            finished.add((VarInteger) tm.getStack().pop());
        }

        _tm.setFinished(tm.isFinished());

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
