package me.okx.neim.var;

public class FibonacciInfiniteList extends InfiniteList {
    @Override
    public VarInteger get(int index) {
        VarInteger v = new VarInteger();
        if (internalList.size() > index) {
            v.setValue(internalList.get(index));
        } else {
            long a = 0;
            long b = 1;
            long tmp;
            for (int i = 0; i < index; i++) {
                tmp = a;
                a = a + b;
                b = tmp;
                if (!this.internalList.contains(a)) {
                    this.internalList.add(a);
                }
            }
            v.setValue(a);
        }
        return v;
    }
}
