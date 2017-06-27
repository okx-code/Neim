package me.okx.neim.token.tokens.monad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Monad;
import me.okx.neim.var.IntList;

public class Transpose implements Monad<IntList> {

    @Override
    public NStack monad(IntList a) {
        IntList firstHalf = new IntList();
        IntList secondHalf = new IntList();

        for(int i = 0; i < a.size()/2; i++) {
            firstHalf.add(a.get(i));
        }

        for(int i = a.size()/2; i < a.size(); i++) {
            secondHalf.add(a.get(i));
        }

        IntList result = new IntList();

        for(int i = 0; i < firstHalf.size(); i++) {
            result.add(firstHalf.get(i));
            result.add(secondHalf.get(i));
        }
        if(firstHalf.size() < secondHalf.size()) {
            result.add(secondHalf.get(secondHalf.size()-1));
        }

        return new NStackBuilder(result).build();
    }
}
