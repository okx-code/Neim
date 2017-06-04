package me.okx.neim.stack;

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

    public NStackBuilder addAll(NStack nstack) {
        for(Object o : nstack) {
            this.add(o);
        }
        return this;
    }
}
