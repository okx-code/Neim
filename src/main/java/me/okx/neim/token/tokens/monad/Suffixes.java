package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Suffixes implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        IntList list = new IntList();
        String sa = a.toString();

        for(int i = 0; i < sa.length(); i++) {
            list.add(new VarInteger(sa.substring(i, sa.length())));
        }

        return new NStackBuilder(list).build();
    }
}
