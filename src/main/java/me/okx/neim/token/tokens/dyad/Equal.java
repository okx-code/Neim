package me.okx.neim.token.tokens.dyad;

import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.vectorisable.Vectorisable;
import me.okx.neim.util.Util;

public class Equal extends Vectorisable implements Dyad<Object, Object> {

    @Override
    public NStack dyad(Object a, Object b) {
        return new NStackBuilder(Util.booleanToNumber(a.equals(b))).build();
    }
}
