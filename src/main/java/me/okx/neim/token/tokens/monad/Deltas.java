package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Deltas implements Monad<IntList> {

    @Override
    public NStack monad(IntList a) {
        IntList deltas = new IntList();
        for(int i = 1; i < a.size(); i++) {
            deltas.add(new VarInteger(a.get(i).getValue()-a.get(i-1).getValue()));
        }
        return new NStackBuilder(deltas).build();
    }
}
