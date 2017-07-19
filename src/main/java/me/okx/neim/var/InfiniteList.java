package me.okx.neim.var;

public abstract class InfiniteList extends IntList {
    //protected List<Long> internalList = new ArrayList<>();
    //protected int shift = 0;

    /*@Override
    public int size() {
        return Integer.MAX_VALUE;
    }*/

    public InfiniteList() {
        int index = 0;
        while(true) {
            try {
                this.add(infGet(index));
                index++;
            } catch(Exception ex) {
                break;
            }
        }
    }

    /*@Override
    public VarInteger get(int index) {
        return infGet(index + shift);
    }*/

    public abstract VarInteger infGet(int index);

    @Override
    public String toString() {
        return "[infinite list]";
        /*StringBuilder sb = new StringBuilder("[");
        int i = 0;
        VarInteger get = get(i);
        while(true) {
            sb.append(get);
            i++;
            get = get(i);
            if(get.getValue() < 0) {
                break;
            } else {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();*/
    }

    /*@Override
    public boolean contains(Object obj) {
        // assumes list is incrementing
        if(!(obj instanceof VarInteger)) {
            return false;
        }
        long a = ((VarInteger) obj).getValue();
        int n = 0;
        while(true) {
            long get = get(n).getValue();
            if(get == a) {
                return true;
            } else if(get > a) {
                return false;
            }
            n++;
        }
    }

    @Override
    public VarInteger remove(int index) {
        if(index == 0) {
            shift++;
            return null;
        }
        return null;
    }*/
}