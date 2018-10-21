package entity.moveobject;

import entity.EntityType;
import entity.moveobject.spells.FireBall;
import graphics.Assets;
import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends MoveObject {


    private int attackCounter;

    public Player(float x, float y, Game game, int health, int speed) {
        super(x, y, game, health, speed);
        entityType = EntityType.PLAYER;
        inMove = false;
        actualPosition = ActualPosition.DOWN;
        animationDown = Assets.playerDown;
        animationUp = Assets.playerUp;
        animationLeft = Assets.playerLeft;
        animationRight = Assets.playerRight;
        animationDownLeft = animationDown;
        animationDownRight = animationDown;
        animationUpLeft = animationUp;
        animationUpRight = animationUp;
    }


    @Override
    public void tick() {
        super.counter++;
        attackCounter++;

        inMove = game.getKeyManager().up || game.getKeyManager().left || game.getKeyManager().right || game.getKeyManager().down;
        isKeyPressed();

    }
    @Override
    public void render(Graphics g) {

        renderMove(g);

    }

    @Override
    protected void renderMove(Graphics g) {
        BufferedImage[] animation = super.getActualAnimation();
        if (inMove) {
            if (counter >= 20) {
                System.out.println("X " +x +"Y " + y);
                moveCounter++;
                if (moveCounter == animation.length) {
                    moveCounter = 0;
                }
                counter =0;
            }
            g.drawImage(animation[moveCounter], (int) x, (int) y, null);

        } else {
            g.drawImage(animation[1], (int) x, (int) y, null);
        }
    }

    private void atack() {
    if (attackCounter >20) {
        new FireBall(x, y, game, 1, 5, actualPosition,EntityType.PLAYER_ATTACK);
        attackCounter=0;
    }
    }



    private void isKeyPressed() {
        if (game.getKeyManager().up) {
            y += -speed;
            if (game.getKeyManager().left) {
                actualPosition = ActualPosition.UP_LEFT;
            } else if (game.getKeyManager().right) {
                actualPosition = ActualPosition.UP_RIGHT;
            } else {
                actualPosition = ActualPosition.UP;
            }
        }
        if (game.getKeyManager().down) {
            y += speed;
            if (game.getKeyManager().left) {
                actualPosition = ActualPosition.DOWN_LEFT;
            } else if (game.getKeyManager().right) {
                actualPosition = ActualPosition.DOWN_RIGHT;
            } else {
                actualPosition = ActualPosition.DOWN;
            }
        }
        if (game.getKeyManager().left) {
            x += -speed;
            if (game.getKeyManager().up) {
                actualPosition = ActualPosition.UP_LEFT;
            } else if (game.getKeyManager().down) {
                actualPosition = ActualPosition.DOWN_LEFT;
            } else {
                actualPosition = ActualPosition.LEFT;
            }
        }
        if (game.getKeyManager().right) {
            x += speed;
            if (game.getKeyManager().up) {
                actualPosition = ActualPosition.UP_RIGHT;
            } else if (game.getKeyManager().down) {
                actualPosition = ActualPosition.DOWN_RIGHT;
            } else {
                actualPosition = ActualPosition.RIGHT;
            }
        }

            if (game.getKeyManager().CTRL) {
                atack();
        }

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


}

