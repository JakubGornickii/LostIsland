package state;

import entity.creature.Player;
import graphics.Assets;
import graphics.BgManager;
import main.Game;

import java.awt.*;

public class GameState extends State {

    private final int START_POSITION_X = game.getWidth()/2;
    private final int START_POSITION_Y = game.getHeight()/2;
    private Player player;
    private BgManager bgManager;

    public GameState(Game game) {
        super(game);
        player = new Player(game, START_POSITION_X, START_POSITION_Y,1);
        bgManager = new BgManager(game , player);

    }

    @Override
    public void tick() {
        player.tick();
    }


    @Override
    public void render(Graphics g) {
        bgManager.renderBg(player.getX(), player.getY(), Assets.getMap1(), Assets.getAssets1(), g);
        {
            player.render(g);
        }


    }


}
