package com.gobartsdev.gobartssim.engine.world;

import com.gobartsdev.gobartssim.engine.world.entities.Entity;
import com.gobartsdev.gobartssim.enums.Dimensions;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.gobartsdev.gobartssim.enums.Tiles.WALL;

public class World {
    private final List<Entity> entities = new ArrayList<>();
    private final TileMap tileMap;
    private final int height = Dimensions.WIN_H.getValue();
    private final int width = Dimensions.WIN_W.getValue();

    public World() {
        this.tileMap = TileMap.getInstance();
    }

    public void add(Entity e) { entities.add(e); }

    public void update(Set<Integer> keysDown) {
        for (Entity e : entities) e.update(keysDown, this);
    }

    public void render(Graphics2D g) {
        tileMap.render(g);
        for (Entity e : entities) e.render(g);
    }

    public boolean canMoveTo(int x, int y, int width, int height) {
        return !tileMap.isSolidAt(x, y)
                && !tileMap.isSolidAt(x + width - 1, y)
                && !tileMap.isSolidAt(x, y + height - 1)
                && !tileMap.isSolidAt(x + width - 1, y + height - 1);
    }



    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
