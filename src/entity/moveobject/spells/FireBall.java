package entity.moveobject.spells;

import entity.EntityType;
import entity.moveobject.ActualPosition;
import graphics.Assets;
import main.Game;

import java.awt.*;

public class FireBall extends Spells {

    private int range = 250;
    private final float START_X,START_Y;



    public FireBall(float x, float y, Game game, int health, int speed, ActualPosition actualPosition, EntityType entityType) {
        super(x, y, game, health, speed,entityType);
        this.actualPosition = actualPosition;
        animationDown = Assets.fireballDown;
        animationUp = Assets.fireballUp;
        animationLeft = Assets.fireballLeft;
        animationRight = Assets.fireballRight;
        animationDownLeft = Assets.fireballDownLeft;
        animationDownRight = Assets.fireballDownRight;
        animationUpLeft = Assets.fireballUpLeft;
        animationUpRight = Assets.fireballUpRight;
        super.inMove = true;
        START_X = super.x;
        START_Y = super.y;
    }

    @Override
    public void tick() {
        if (actualPosition == ActualPosition.DOWN) {
            y += speed;
        }
        if (actualPosition == ActualPosition.UP) {
            y += -speed;
        }
        if (actualPosition == ActualPosition.LEFT) {
            x += -speed;
        }
        if (actualPosition == ActualPosition.RIGHT) {
            x += speed;
        }
        if (actualPosition == ActualPosition.DOWN_LEFT) {
            y += speed;
            x += -speed;
        }
        if (actualPosition == ActualPosition.DOWN_RIGHT) {
            y += speed;
            x += speed;
        }
        if (actualPosition == ActualPosition.UP_LEFT) {
            y += -speed;
            x += -speed;
        }
        if (actualPosition == ActualPosition.UP_RIGHT) {
            y += -speed;
            x += speed;
        }
if (START_X > super.x + range || START_X < super.x - range
|| START_Y > super.y + range || START_Y < super.y - range){
    super.setActive(false);
}
    }

    @Override
    public void render(Graphics g) {
        super.renderMove(g);
    }

}
