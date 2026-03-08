package com.gobartsdev.gobartssim.engine.world.entities.objects;

import com.gobartsdev.gobartssim.engine.world.World;
import com.gobartsdev.gobartssim.engine.world.entities.Entity;
import com.gobartsdev.gobartssim.enums.Dimensions;
import com.gobartsdev.gobartssim.util.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Set;

public class Plant extends Entity {
    BufferedImage image;

    public Plant(int x, int y) {
        this.x = x;
        this.y = y;
        image = ImageUtil.loadImage("/objects/plant.png");
    }


    @Override
    public void update(Set<Integer> keysDown, World world) {

    }

    @Override
    public void render(Graphics2D g) {
       g.drawImage(
                    image,
                    x + Dimensions.TILE_SIZE.getValue(),
                    y,
                    - Dimensions.TILE_SIZE.getValue(),
                    Dimensions.TILE_SIZE.getValue(),
                    null
            );
    }
}
