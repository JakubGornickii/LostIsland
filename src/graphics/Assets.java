package graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static SpriteLoader spriteLoader;
    private static BufferedImage[] assets1;
    private static BufferedImage[] entitiyAssets;
    private static int[][] map1;
    public static Graphics g;


    //player assets
    public static BufferedImage[] playerLeft;
    public static BufferedImage[] playerRight;
    public static BufferedImage[] playerUp;
    public static BufferedImage[] playerDown;
    public static BufferedImage player;


    public static BufferedImage[] getAssets1() {
        return assets1;
    }

    public static int[][] getMap1() {
        return map1;
    }

    public static void init() {
        //entity assets
       spriteLoader = new SpriteLoader("/1.png");
       entitiyAssets = spriteLoader.getTailSet();
        // player assets
        playerDown = new BufferedImage[]{entitiyAssets[0], entitiyAssets[1], entitiyAssets[2]};
        playerRight = new BufferedImage[]{entitiyAssets[24], entitiyAssets[25], entitiyAssets[26]};
        playerUp = new BufferedImage[]{entitiyAssets[36], entitiyAssets[37], entitiyAssets[38]};
        playerLeft = new BufferedImage[]{entitiyAssets[12], entitiyAssets[13], entitiyAssets[14]};
        // lvl 1 assets load
        spriteLoader = new SpriteLoader("/2.png", "/2.map");

        assets1 = spriteLoader.getTailSet();
        map1 = spriteLoader.getMap();
        // lvl 2 assets load

    }


}
