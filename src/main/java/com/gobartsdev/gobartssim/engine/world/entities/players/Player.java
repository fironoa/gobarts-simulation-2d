package com.gobartsdev.gobartssim.engine.world.entities.players;

import com.gobartsdev.gobartssim.engine.world.TileMap;
import com.gobartsdev.gobartssim.engine.world.World;
import com.gobartsdev.gobartssim.engine.world.entities.Entity;
import com.gobartsdev.gobartssim.enums.ControlScheme;
import com.gobartsdev.gobartssim.enums.Dimensions;
import com.gobartsdev.gobartssim.util.ImageUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Set;


public class Player extends Entity {
    final Color color;
    final ControlScheme controls;
    final BufferedImage image;
    boolean facingLeft = false;
    int speed = 4;

    public Player(int x, int y, Color color, ControlScheme controls) {
        this.x = x; this.y = y;
        this.w = Dimensions.TILE_SIZE.getValue();
        this.h = Dimensions.TILE_SIZE.getValue();
        this.color = color;
        this.controls = controls;
        this.image = ImageUtil.loadImage("/objects/hen.png");
    }

    @Override
    public void update(Set<Integer> keysDown, World world) {
        int dx = 0, dy = 0;

        if (controls == ControlScheme.ARROWS) {
            if (keysDown.contains(KeyEvent.VK_LEFT)) {
                dx -= speed;
                facingLeft = true;
            }
            if (keysDown.contains(KeyEvent.VK_RIGHT)) {
                dx += speed;
                facingLeft = false;
            }
            if (keysDown.contains(KeyEvent.VK_UP)) {
                dy -= speed;
            }
            if (keysDown.contains(KeyEvent.VK_DOWN)) {
                dy += speed;
            }
        } else { // WASD
            if (keysDown.contains(KeyEvent.VK_A)) {
                dx -= speed;
                facingLeft = true;
            }
            if (keysDown.contains(KeyEvent.VK_D)) {
                dx += speed;
                facingLeft = false;
            }
            if (keysDown.contains(KeyEvent.VK_W)) {
                dy -= speed;
            }
            if (keysDown.contains(KeyEvent.VK_S)) {
                dy += speed;
            }
        }

        // Resolve X first
        if (dx != 0 && world.canMoveTo(x + dx, y, w, h)) {
            x += dx;
        }

        // Resolve Y second
        if (dy != 0 && world.canMoveTo(x, y + dy, w, h)) {
            y += dy;
        }

        // Clamp to panel bounds (0..worldW/worldH)
        x = clamp(x, 0, world.getWidth() - w);
        y = clamp(y, 0, world.getHeight() - h);
    }

    private int clamp(int v, int min, int max) {
        if (max < min) return min; // if window is tiny
        return Math.max(min, Math.min(max, v));
    }

    @Override
    public void render(Graphics2D g) {
        if(!facingLeft) {
            g.drawImage(
                    image,
                    x + Dimensions.TILE_SIZE.getValue(),
                    y,
                    - Dimensions.TILE_SIZE.getValue(),
                    Dimensions.TILE_SIZE.getValue(),
                    null
            );
        } else {
            g.drawImage(
                    image,
                    x,
                    y,
                    Dimensions.TILE_SIZE.getValue(),
                    Dimensions.TILE_SIZE.getValue(),
                    null
            );
        }
    }

}
