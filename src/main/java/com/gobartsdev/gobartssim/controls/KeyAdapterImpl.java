package com.gobartsdev.gobartssim.controls;

import com.gobartsdev.gobartssim.engine.game.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapterImpl extends KeyAdapter {

    private final Game game;

    public KeyAdapterImpl(Game game){
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.keyDown(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        game.keyUp(e.getKeyCode());
    }
}
