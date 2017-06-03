package me.okx.neim.token.tokens.list;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.var.PerfectNumbersInfiniteList;

public class Perfect implements Nilad {

    @Override
    public NStack nilad() {
        return new NStackBuilder(new PerfectNumbersInfiniteList()).build();
    }
}
