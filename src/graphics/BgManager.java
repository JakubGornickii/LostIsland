package graphics;

import entity.creature.Player;
import main.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BgManager {

    private Player player;
    private int width, height;
    private final int TAIL_SIZE = 32;
    private final int SCROLLING_Y = 150;
    private final int SCROLLING_X = 150;
    private int bgX, bgY;
    private int bgActualtailRow;
    private int bgActualtailCol;
    private int numRowsToDraw;
    private int numColsToDraw;
    private int offSetX;
    private int offSetY;

    public BgManager(Game game, Player player) {
        this.player = player;
        offSetX = 0;
        offSetY = 0;
        this.width = game.getWidth();
        this.height = game.getHeight();
        numColsToDraw = height / TAIL_SIZE;
        if (numColsToDraw * 32 < height) {
            numColsToDraw++;
        }
        numRowsToDraw = width / TAIL_SIZE;
        if (numRowsToDraw * 32 < width) {
            width++;
        }
        initBgStartPosition(player.getX(), player.getY());
    }

    public Graphics renderBg(float playerX, float playerY, int[][] map, BufferedImage[] assets, Graphics graphics) {

        if (playerY - SCROLLING_Y < bgY) {
            offSetY += player.getSpeed();
            player.setY(player.getY() + player.getSpeed());

        }
        if (playerY - SCROLLING_Y > bgY + height / 2) {
            offSetY -= player.getSpeed();
            player.setY(player.getY() - player.getSpeed());
        }
        if (playerX - SCROLLING_X < bgX) {
            offSetX += player.getSpeed();
            player.setX(player.getX() + player.getSpeed());

        }
        if (playerX - SCROLLING_X > bgX + width / 2) {
            offSetX -= player.getSpeed();
            player.setX(player.getX() - player.getSpeed());

        }
        if (offSetY < -31) {
            bgActualtailCol++;
            offSetY = 0;
        }
        if (offSetY > 31) {
            if (bgActualtailCol > 0) {
                bgActualtailCol--;
                offSetY = 0;
            } else {
                offSetY = 32;
            }

        }
        if (offSetX < -31) {
            bgActualtailRow++;
            offSetX = 0;
        }
        if (offSetX > 31) {
            if (bgActualtailRow > 0) {
                bgActualtailRow--;
                offSetX = 0;
            } else {
                offSetX = 32;
            }
        }


        for (int i = bgActualtailRow; i < numRowsToDraw + bgActualtailRow + 2; i++) {

            for (int j = bgActualtailCol; j < numColsToDraw + bgActualtailCol + 2; j++) {
                graphics.drawImage(assets[map[j][i] - 1], -32 + ((i - bgActualtailRow) * TAIL_SIZE) + offSetX, -32 + ((j - bgActualtailCol) * TAIL_SIZE) + offSetY, null);
            }
        }
        return graphics;
    }

    private void initBgStartPosition(float playerX, float playerY) {
        bgX = (int) (playerX - width / 2);
        bgY = (int) (playerY - height / 2);
        bgActualtailCol = bgX / TAIL_SIZE;
        if (bgActualtailCol < 0) {
            bgActualtailCol = 0;
        }
        bgActualtailRow = bgY / TAIL_SIZE;
        if (bgActualtailRow < 0) {
            bgActualtailRow = 0;
        }
        System.out.println(bgActualtailRow + " " + bgActualtailCol);
        System.out.println(numRowsToDraw + " " + numColsToDraw);
    }
}
