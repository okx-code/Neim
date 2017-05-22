package me.okx.neim.stack;

import lombok.Getter;
import me.okx.neim.util.InputUtil;

import java.util.Stack;

public class NStack extends Stack {
    @Getter
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
