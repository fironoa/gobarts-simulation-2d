package com.gobartsdev.gobartssim.engine.world.entities;

import com.gobartsdev.gobartssim.engine.world.World;

import java.awt.*;
import java.util.Set;

public abstract class Entity {
    protected int x;
    protected int y;

    protected int w;
    protected int h;

    public abstract void update(Set<Integer> keysDown, World world);
    public abstract void render(Graphics2D g);
}