package entity.creature;

import graphics.Assets;
import main.Game;

import java.awt.*;

public class Player extends Creature {

    private Game game;
int counter;

    public Player(Game game,float x, float y,int speed) {
        super(x, y,speed);
        this.game = game;
    }

    @Override
    public void tick() {
        if(game.getKeyManager().up){
            y += -3;
        }
        if(game.getKeyManager().down){
            y += 3;
        }
        if(game.getKeyManager().left){
            x += -3;
        }
        if(game.getKeyManager().right){
            x += 3;
        }
counter++;
        if (counter == 50){
            System.out.println("x="+x+" y="+y);
counter=0;
        }

    }

    @Override
    public void render(Graphics g) {
g.drawImage(Assets.player,(int)x,(int)y,null);
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
    public int getSpeed(){
        return super.speed;
    }

}
