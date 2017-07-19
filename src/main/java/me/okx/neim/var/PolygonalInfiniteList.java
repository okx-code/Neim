package me.okx.neim.var;

public class PolygonalInfiniteList extends InfiniteList {
    private long s = 0;

    public PolygonalInfiniteList(long sides) {
        this.s = sides;
    }

    @Override
    public VarInteger infGet(int index) {
        long n = index;
        n = (n*n*(s-2)-n*(s-4))/2;

        return new VarInteger(n);
    }
}
