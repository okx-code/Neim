package me.okx.neim.token.types;

import lombok.Getter;
import me.okx.neim.stack.NStack;

public class SpecialData implements Token {
    @Getter
    private String value;
    @Getter
    private NStack stack;

    public SpecialData(String value, NStack stack) {
        this.value = value;
        this.stack = stack;
    }
}
