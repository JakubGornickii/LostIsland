package entity.creature;

import entity.Entity;

public abstract class Creature extends Entity {

    protected int health;
    protected int speed;

    public Creature(float x, float y, int speed) {
        super(x, y);
        health = 10;
        this.speed = speed;
    }


}
