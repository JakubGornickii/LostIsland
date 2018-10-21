package entity.moveobject.enemy;

import entity.EntityType;
import entity.moveobject.ActualPosition;
import entity.moveobject.MoveObject;
import graphics.Assets;
import main.Game;

import java.awt.*;

public class Mage extends MoveObject {
    public Mage(float x, float y, Game game, int health, int speed) {
        super(x, y, game, health, speed);
        entityType = EntityType.ENEMY;
        actualPosition = ActualPosition.DOWN;
        animationDown = Assets.mageDown;
        animationUp = Assets.mageUp;
        animationLeft = Assets.mageLeft;
        animationRight = Assets.mageRight;
        animationDownLeft = animationDown;
        animationDownRight = animationDown;
        animationUpLeft = animationUp;
        animationUpRight = animationUp;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        super.renderMove(g);
    }
}
