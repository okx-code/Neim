package me.okx.neim.stack;

import lombok.Getter;
import lombok.Setter;
import me.okx.neim.util.InputUtil;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.Stack;

public class NStack extends Stack {
    @Setter
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

    public IntList popList() {
        Object p = this.pop();
        if(p instanceof VarInteger) {
            return ((VarInteger) p).chars();
        } else {
            return (IntList) p;
        }
    }

    public VarInteger popInt() {
        Object p = this.pop();
        if(p instanceof IntList) {
            return ((IntList) p).join();
        } else {
            return (VarInteger) p;
        }
    }
}
