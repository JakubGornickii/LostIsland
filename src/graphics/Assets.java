package graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static SpriteLoader spriteLoader;
    private static BufferedImage[] assets1;
    private static int[][] map1;

    public static BufferedImage[] getAssets1() {
        return assets1;
    }

    public static int[][] getMap1() {
        return map1;
    }

    public static void init() {
        // lvl 1 assets load
        spriteLoader = new SpriteLoader("/2.png", "/2.map");
        assets1 = spriteLoader.getTailSet();
        map1 = spriteLoader.getMap();
        // lvl 2 assets load

    }

    public static Graphics renderBg(int[][] map, BufferedImage[] assets, Graphics graphics) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                graphics.drawImage(assets[map[j][i] - 1], i * 32, j * 32, null);
            }
        }
        return graphics;
    }
}
