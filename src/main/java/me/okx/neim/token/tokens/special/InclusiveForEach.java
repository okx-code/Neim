package me.okx.neim.token.tokens.special;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Special;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InclusiveForEach implements Special {

    @Override
    public NStack special(NStack stack, String value, TokenManager _tm) {
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
        TokenManager tm = new TokenManager();
        List<VarInteger> finished = new ArrayList<>();
        for(int i = 0; i < a.size(); i++) {
            VarInteger var = a.get(i);
            tm = new TokenManager();
            tm.getInput().setInputStream(stack.getInput().getInputStream());
            tm.getInput().setInputs(stack.getInput().getInputs());
            tm.getStack().addAll(stack);
            tm.getStack().push(var);
            tm.registerTokens(var.getValue(), i);
            tm.handleTokens(value, _tm.isDebug());
            VarInteger pop = tm.getStack().popInt().clone();
            finished.add(pop);
        }

        IntList end = new IntList();

        for(VarInteger f : finished) {
            end.add(f);
        }

        _tm.setFinished(tm.isFinished());

        return new NStackBuilder(end).build();
    }

    public void f(Function<Integer, Integer> g) {
        g.apply(3);
    }

    public void g() {
        f(a->{int t=1;for(;a>0;a--)t*=a;return t;});
    }
}