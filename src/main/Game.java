package main;

import display.Display;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private boolean running = false;
    private Display display;
    private int width, height;
    private Thread thread;
    private String title;
    private Graphics graphics;
    private BufferStrategy bufferStrategy;
    private BufferedImage image;


    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
    }

    private void update() {

    }

    private void render() {
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, width, height);
        Assets.renderBg(Assets.getMap1(),Assets.getAssets1(),graphics);
        bufferStrategy.show();
        graphics.dispose();

    }

    @Override
    public void run() {
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long timer = 0;
        int ticks = 0;
        long lastTime = System.nanoTime();


        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS:" + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    }

    private void init() {
        display = new Display(title, width, height);
        Assets.init();

    }

    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
