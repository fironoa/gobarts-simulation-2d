package com.gobartsdev.gobartssim.enums;

public enum Dimensions {
    TILE_SIZE(32),
    WIN_W(20 * TILE_SIZE.getValue()),
    WIN_H(10 * TILE_SIZE.getValue());

    private final int value;

    Dimensions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
