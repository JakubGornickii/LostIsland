package entity;

import objectManager.ActiveObject;

import java.awt.*;

public abstract class Entity {
    protected EntityType entityType;
    private boolean active;
    protected float x, y;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
        active = true;
        ActiveObject.objects.add(this);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
