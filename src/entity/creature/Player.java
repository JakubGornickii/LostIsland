package entity.creature;

import graphics.Assets;
import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Game game;
    int counter;
    int moveCounter;
    private ActualPosition actualPosition;
    private boolean inMove;

    public Player(Game game, float x, float y, int speed) {
        super(x, y, speed);
        this.game = game;
        actualPosition = ActualPosition.DOWN;
    }

    @Override
    public void tick() {
        inMove = game.getKeyManager().up || game.getKeyManager().left || game.getKeyManager().right || game.getKeyManager().down;
        if (game.getKeyManager().up) {
            y += -speed;
            actualPosition = ActualPosition.UP;
        }
        if (game.getKeyManager().down) {
            y += speed;
            actualPosition = ActualPosition.DOWN;
        }
        if (game.getKeyManager().left) {
            x += -speed;
            actualPosition = ActualPosition.LEFT;
        }
        if (game.getKeyManager().right) {
            x += speed;
            actualPosition = ActualPosition.RIGHT;
        }
        counter++;
        if (counter == 50) {
            System.out.println("x=" + x + " y=" + y);
            counter = 0;
        }

    }

    @Override
    public void render(Graphics g) {

        renderMove(g);

    }

    private void renderMove(Graphics g) {

        BufferedImage[] animation = getActualAnimation();
        if (inMove) {
            if (game.getTicks() % 10 == 0) {
                moveCounter++;
                if (moveCounter == 3) {
                    moveCounter = 0;
                }
            }
            g.drawImage(animation[moveCounter], (int) x, (int) y, null);

        } else {
            g.drawImage(animation[1], (int) x, (int) y, null);
        }



    }

    private BufferedImage[] getActualAnimation() {
        if (actualPosition == ActualPosition.DOWN){
            return Assets.playerDown;
        }
        if (actualPosition == ActualPosition.LEFT){
            return Assets.playerLeft;
        }
        if (actualPosition == ActualPosition.UP){
            return Assets.playerUp;

        }
        if (actualPosition == ActualPosition.RIGHT){
            return Assets.playerRight;
        }
        return null;
    }


    public float getX() {
        return super.x;
    }

    public float getY() {
        return super.y;
    }

    public float setX(float x) {
        return super.x = x;
    }

    public float setY(float y) {
        return super.y = y;
    }

    public int getSpeed() {
        return super.speed;
    }


    private enum ActualPosition {

        LEFT, RIGHT, UP, DOWN;

    }
}

