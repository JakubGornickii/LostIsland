package entity.moveobject.spells;

import entity.EntityType;
import entity.moveobject.MoveObject;
import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Spells extends MoveObject {
    public Spells(float x, float y, Game game, int health, int speed, EntityType entityType) {
        super(x, y, game, health, speed);
        super.entityType = entityType;
    }
    @Override
    protected void renderMove(Graphics g) {
        BufferedImage[] animation = getActualAnimation();
        if (inMove) {
            if (counter >= 20) {

                moveCounter++;
                if (moveCounter == animation.length) {
                    moveCounter = 0;
                }
                counter = 0;
            }
            g.drawImage(animation[moveCounter], (int) x, (int) y, null);

        } else {
            g.drawImage(animation[1], (int) x, (int) y, null);
        }
    }
}
