package me.okx.neim.stack;

public class NStackBuilder {
    private NStack stack;

    public NStackBuilder(Object elem) {
        stack = new NStack(null);
        stack.push(elem);
    }

    public NStackBuilder add(Object elem) {
        stack.add(elem);
        return this;
    }

    public NStack build() {
        return stack;
    }
}
