package com.gobartsdev.gobartssim.engine.game;

import com.gobartsdev.gobartssim.controls.KeyAdapterImpl;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    private final Game game;
    private Thread gameThread;
    private volatile boolean running = true;

    public GamePanel(Game game){
        this.game = game;
        setFocusable(true);
        addKeyListener(new KeyAdapterImpl(game));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        game.render(g2);
    }

    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final double UPS = 60.0;
        final long STEP_NANOS = (long) (1_000_000_000L / UPS);

        long previous = System.nanoTime();
        long lag = 0;

        while (running) {
            long now = System.nanoTime();
            long elapsed = now - previous;
            previous = now;

            if (elapsed > 250_000_000L) elapsed = 250_000_000L;

            lag += elapsed;

            while (lag >= STEP_NANOS) {
                game.update();
                lag -= STEP_NANOS;
            }

            repaint();

            long sleepNanos = STEP_NANOS - lag;
            if (sleepNanos > 0) {
                try {
                    Thread.sleep(sleepNanos / 1_000_000L, (int)(sleepNanos % 1_000_000L));
                } catch (InterruptedException ignored) {}
            }
        }
    }
}
