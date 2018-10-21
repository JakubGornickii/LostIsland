package state;

import entity.Entity;
import entity.moveobject.Player;
import entity.moveobject.enemy.Mage;
import graphics.Assets;
import graphics.BgManager;
import main.Game;
import objectManager.ActiveObject;

import java.awt.*;
import java.util.zip.Adler32;

public class GameState extends State {

    private final int START_POSITION_X = game.getWidth() / 2;
    private final int START_POSITION_Y = game.getHeight() / 2;
    private Player player;
    private Mage mage;
    private BgManager bgManager;

    public GameState(Game game) {
        super(game);

        player = new Player(START_POSITION_X, START_POSITION_Y, game, 30, 1);
        mage = new Mage(300,300,game,50,5);
        bgManager = new BgManager(game, player);

    }

    @Override
    public void tick() {

    for (Entity object : ActiveObject.objects) {
            object.tick();
            if (!object.isActive()){
                ActiveObject.objects.remove(object);
            }
        }}



    @Override
    public void render(Graphics g) {
        bgManager.renderBg(player.getX(), player.getY(), Assets.getMap1(), Assets.getAssets1(), g);
        {
            for (Entity object : ActiveObject.objects) {
                object.render(g);
            }
        }


    }


}
