package main;

import display.Display;
import graphics.Assets;
import input.KeyManager;
import objectManager.ActiveObject;
import state.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private boolean running;
    private Display display;
    private int width, height;
    private Thread thread;
    private String title;
    private Graphics g;
    private BufferStrategy bs;
    private BufferedImage image;
    private KeyManager keyManager;

    //states
    private State gameState;
    private State menuState;
    private State optionState;
    private State creditsState;


    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
        keyManager = new KeyManager();
        running =false;

    }

    private void tick() {
        keyManager.tick();
if(CurrentState.getCurrentState() != null){
    CurrentState.getCurrentState().tick();
}
    }

    private void render() {


        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);


           if (CurrentState.getCurrentState() != null){
               CurrentState.getCurrentState().render(g);
           }


            bs.show();
            g.dispose();


    }



    @Override
    public void run() {
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        int ticks;
        long now;
        long timer = 0;
        ticks = 0;
        long lastTime = System.nanoTime();


        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;

            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
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
        display.getjFrame().addKeyListener(keyManager);
        Assets.init();
        gameState = new GameState(this);
        creditsState = new CreditsState(this);
        optionState = new OptionsState(this);
        menuState = new MenuState(this);
        CurrentState.setCurrentState(gameState);

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

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
