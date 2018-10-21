package graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static SpriteLoader spriteLoader;
    private static BufferedImage[] assets1;
    private static BufferedImage entitiyAssets;
    private static int[][] map1;
    public static Graphics g;
    public static BufferedImage player;

    public static BufferedImage[] getAssets1() {
        return assets1;
    }

    public static int[][] getMap1() {
        return map1;
    }

    public static void init() {
        //entity assets
        entitiyAssets = ImageLoader.load("/1.png");
        player = entitiyAssets.getSubimage(0,0,32,32);
        // lvl 1 assets load
        spriteLoader = new SpriteLoader("/2.png", "/2.map");

        assets1 = spriteLoader.getTailSet();
        map1 = spriteLoader.getMap();
        // lvl 2 assets load

    }


}
