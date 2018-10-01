package state;

import entity.creature.Player;
import graphics.Assets;
import main.Game;

import java.awt.*;

public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);


        player = new Player(game,100,100);
    }

    @Override
    public void tick() {
player.tick();
    }



    @Override
    public void render(Graphics g) {
        Assets.renderBg(Assets.getMap1(),Assets.getAssets1(), g);{
        player.render(g);
    }


}


}
