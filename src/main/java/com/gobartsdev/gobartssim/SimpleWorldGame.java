package com.gobartsdev.gobartssim;

import com.gobartsdev.gobartssim.engine.game.Game;
import com.gobartsdev.gobartssim.engine.game.GamePanel;
import com.gobartsdev.gobartssim.enums.Dimensions;

import javax.swing.*;

public class SimpleWorldGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            GamePanel panel = new GamePanel(game);

            JFrame frame = new JFrame("Game Loop Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.setSize(Dimensions.WIN_W.getValue(),Dimensions.WIN_H.getValue());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            panel.startGameLoop();
            panel.requestFocusInWindow();
        });
    }
}