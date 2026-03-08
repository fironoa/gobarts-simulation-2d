package com.gobartsdev.gobartssim.engine.world;

import com.gobartsdev.gobartssim.enums.Dimensions;
import com.gobartsdev.gobartssim.enums.Tiles;
import com.gobartsdev.gobartssim.util.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.gobartsdev.gobartssim.enums.Tiles.WALL;

public class TileMap {


    private final int tileSize = Dimensions.TILE_SIZE.getValue();
    private BufferedImage rock;
    private BufferedImage sand;

    private int[][] map = {
            {Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue()},
            {Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue()},
            {Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue()},
            {Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue()},
            {Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue()},
            {Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue()},
            {Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.SAND.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue()},
            {Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue(),Tiles.WALL.getValue()}
    };
    
    private TileMap(){
       this.rock = ImageUtil.loadImage("/objects/rock.png");
       this.sand = ImageUtil.loadImage("/objects/sand.png");
    }

    private static class Holder {
        private static final TileMap INSTANCE = new TileMap();
    }
    public static TileMap getInstance() {
        return Holder.INSTANCE;
    }

    public int[][] getMap() {
        return map;
    }

    public boolean isSolidAt(int pixelX, int pixelY) {

        int tileX = pixelX / Dimensions.TILE_SIZE.getValue();
        int tileY = pixelY / Dimensions.TILE_SIZE.getValue();

        return map[tileY][tileX] == WALL.getValue();
    }

    public void render(Graphics2D g) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {

                BufferedImage image = null;
                int pixelX = col * tileSize;
                int pixelY= row * tileSize;
                image = switch (map[row][col]) {
                    case 1 -> sand;
                    default -> rock;
                };
                g.drawImage(image, pixelX, pixelY, null);
            }
        }
    }
}
