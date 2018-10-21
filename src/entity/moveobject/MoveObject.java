package entity.moveobject;

import entity.Entity;
import main.Game;
import objectManager.ScreenPosition;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MoveObject extends Entity {
    protected Game game;
    protected boolean inMove;
    protected BufferedImage[] animationLeft;
    protected BufferedImage[] animationRight;
    protected BufferedImage[] animationUp;
    protected BufferedImage[] animationDown;
    protected BufferedImage[] animationDownLeft;
    protected BufferedImage[] animationDownRight;
    protected BufferedImage[] animationUpLeft;
    protected BufferedImage[] animationUpRight;
    protected int moveCounter;
    protected ActualPosition actualPosition;
    protected int health;
    protected int speed;
    protected int counter;

    public MoveObject(float x, float y, Game game, int health, int speed) {
        super(x, y);
        this.game = game;
        this.health = health;
        this.speed = speed;
    }


    protected void renderMove(Graphics g){
        BufferedImage[] animation = getActualAnimation();
        if (inMove) {
            if (counter >= 20) {
                System.out.println("X " +x +"Y " + y);
                moveCounter++;
                if (moveCounter == animation.length) {
                    moveCounter = 0;
                }
                counter =0;
            }
            g.drawImage(animation[moveCounter], (int) x + ScreenPosition.xOff, (int) y + ScreenPosition.yOff, null);

        } else {
            g.drawImage(animation[1], (int) x +ScreenPosition.xOff, (int) y +ScreenPosition.yOff, null);
        }
    }

    protected BufferedImage[] getActualAnimation() {
        if (actualPosition == ActualPosition.DOWN) {
            return animationDown;
        }
        if (actualPosition == ActualPosition.LEFT) {
            return animationLeft;
        }
        if (actualPosition == ActualPosition.UP) {
            return animationUp;

        }
        if (actualPosition == ActualPosition.RIGHT) {
            return animationRight;
        }
        if (actualPosition == ActualPosition.DOWN_LEFT){
            return animationDownLeft;
        }
        if (actualPosition == ActualPosition.DOWN_RIGHT){
            return animationDownRight;
        }
        if (actualPosition == ActualPosition.UP_LEFT){
            return animationUpLeft;
        }
        if (actualPosition == ActualPosition.UP_RIGHT){
            return animationUpRight;
        }
        return null;
    }
}
