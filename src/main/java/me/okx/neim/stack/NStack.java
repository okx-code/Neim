package me.okx.neim.stack;

import me.okx.neim.util.InputUtil;

import java.util.Stack;

public class NStack extends Stack {
    private InputUtil input;

    public NStack(InputUtil input) {
        this.input = input;
    }

    @Override
    public Object pop() {
        if(this.size() == 0) {
            return input.getSomething();
        } else {
            return super.pop();
        }
    }
}
