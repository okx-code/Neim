package me.okx.neim.stack;

public class NStackBuilder {
    private NStack stack;

    public NStackBuilder(Object elem) {
        stack = new NStack();
        stack.push(elem);
    }

    public NStack build() {
        return stack;
    }
}
