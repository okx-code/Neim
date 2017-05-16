package me.okx.neim.stack;

import me.okx.neim.util.InputUtil;

import java.util.Stack;

public class NStack extends Stack {
    @Override
    public Object pop() {
        if(this.size() == 0) {
            return InputUtil.getSomething();
        } else {
            return super.pop();
        }
    }
}
