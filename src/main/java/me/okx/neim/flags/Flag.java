package me.okx.neim.flags;

import lombok.Getter;

public enum Flag {
    USEENCODING("c");

    @Getter
    private String name;

    Flag(String name) {
        this.name = name;
    }
}
