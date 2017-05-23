package me.okx.neim.var;

public class PolygonalInfiniteList extends InfiniteList {
    private long s = 0;

    public PolygonalInfiniteList(long sides) {
        this.s = sides;
    }

    @Override
    public VarInteger get(int index) {
        long n = index;
        n = (n*n*(s-2)-n*(s-4))/2;

        if (!this.internalList.contains(n)) {
            this.internalList.add(n);
        }
        return new VarInteger(n);
    }
}
