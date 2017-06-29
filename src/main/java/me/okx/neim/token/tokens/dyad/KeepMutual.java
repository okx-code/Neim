package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class KeepMutual implements Dyad<IntList, IntList> {

    @Override
    public NStack dyad(IntList a, IntList b) {
        IntList ret = new IntList();

        for(VarInteger vib : b) {
            if(a.contains(vib)) {
                ret.add(vib);
            }
        }

        return new NStackBuilder(ret).build();
    }
}
