package me.okx.neim.token.tokens;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Substrings implements Monad<VarInteger> {

    @Override
    public NStack monad(VarInteger a) {
        IntList list = new IntList();
        int len = a.toString().length();
        for(int start = 0; start < len; start++) {
            for(int end = start+1; end <= len; end++) {
                list.add(new VarInteger(Long.parseLong(a.toString().substring(start, end))));
            }
        }
        return new NStackBuilder(list).build();
    }
}
