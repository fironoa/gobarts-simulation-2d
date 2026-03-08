package com.gobartsdev.gobartssim.util;

import com.gobartsdev.gobartssim.enums.Dimensions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.logging.Logger;

public class ImageUtil {
    private final static Logger logger = Logger.getLogger("image-util");

    public static BufferedImage loadImage(String filename){
        try {
            URL url = ImageUtil.class.getResource(filename);
            if(url == null) {
                throw new RuntimeException("Image not found.");
            }
            return ImageIO.read(Objects.requireNonNull(ImageUtil.class.getResource(filename)));
        } catch (Exception e) {
            logger.info("Error loading the image. Falling back to dummy");
            return createDummyTile(Dimensions.TILE_SIZE.getValue());
        }
    }


    public static BufferedImage createDummyTile(int tileSize) {

        BufferedImage img = new BufferedImage(tileSize, tileSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        int cell = 8;

        for (int y = 0; y < tileSize; y += cell) {
            for (int x = 0; x < tileSize; x += cell) {

                if ((x + y) % (cell * 2) == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(Color.GRAY);
                }

                g.fillRect(x, y, cell, cell);
            }
        }

        g.dispose();

        return img;
    }
}
