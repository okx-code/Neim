package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;

public class DuplicateFromUnderneath implements Dyad<Object, Object> {

    @Override
    public NStack dyad(Object a, Object b) {
        return new NStackBuilder(a).add(b).add(a).build();
    }
}
