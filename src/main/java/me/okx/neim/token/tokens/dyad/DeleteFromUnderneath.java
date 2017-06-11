package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;

public class DeleteFromUnderneath implements Dyad<Object, Object> {

    @Override
    public NStack dyad(Object a, Object b) {
        return new NStackBuilder(b).build();
    }
}
