package me.okx.neim.stack;

import java.util.Collection;

public class NStackBuilder {
    private NStack stack;

    public NStackBuilder(Object elem) {
        stack = new NStack(null);
        stack.push(elem);
    }

    public NStackBuilder() {
        stack = new NStack(null);
    }

    public NStackBuilder add(Object elem) {
        stack.push(elem);
        return this;
    }

    public NStack build() {
        return stack;
    }

    public NStackBuilder addAll(Collection n) {
        for(Object o : n) {
            this.add(o);
        }
        return this;
    }
}
