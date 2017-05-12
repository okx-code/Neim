package me.okx.neim.flags;

import lombok.Getter;

public enum Flag {
    CODEPAGE("c");

    @Getter
    private String name;

    Flag(String name) {
        this.name = name;
    }
}
