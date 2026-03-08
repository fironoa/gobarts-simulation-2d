package com.gobartsdev.gobartssim.engine.game;

import com.gobartsdev.gobartssim.engine.world.World;
import com.gobartsdev.gobartssim.engine.world.entities.objects.Plant;
import com.gobartsdev.gobartssim.enums.ControlScheme;
import com.gobartsdev.gobartssim.engine.world.entities.players.Player;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Game {
    private final Set<Integer> keysDown = new HashSet<>();
    private final World world = new World();

    public Game() {
        world.add(new Player(200, 160, Color.RED, ControlScheme.ARROWS));
        //world.add(new Player(260, 150, Color.CYAN, ControlScheme.WASD));
        world.add(new Plant(210, 100));
    }

    public void keyDown(int keyCode) { keysDown.add(keyCode); }
    public void keyUp(int keyCode) { keysDown.remove(keyCode); }

    void update() {
        world.update(keysDown);
    }

    void render(Graphics2D g) {
        world.render(g);
    }
}
