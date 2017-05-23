package me.okx.neim.token.tokens.list;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.PolygonalInfiniteList;
import me.okx.neim.var.VarInteger;

public class Polygonal implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        return new NStackBuilder(new PolygonalInfiniteList(a.getValue())).build();
    }
}
