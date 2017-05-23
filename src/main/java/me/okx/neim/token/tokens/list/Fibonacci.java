package me.okx.neim.token.tokens.list;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.var.FibonacciInfiniteList;

public class Fibonacci implements Nilad {

    @Override
    public NStack nilad() {
        return new NStackBuilder(new FibonacciInfiniteList()).build();
    }
}
