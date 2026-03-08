package com.gobartsdev.gobartssim.enums;

public enum Tiles {
    WALL(0), SAND(1);

    private final int value;

    Tiles(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
