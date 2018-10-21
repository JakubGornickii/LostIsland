package graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    private static SpriteLoader spriteLoader;
    private static BufferedImage[] assets1;
    private static int[][] map1;
    public static Graphics g;

// mage assets
public static BufferedImage[] mageLeft;
    public static BufferedImage[] mageRight;
    public static BufferedImage[] mageUp;
    public static BufferedImage[] mageDown;
    //player assets
    public static BufferedImage[] player;
    public static BufferedImage[] playerLeft;
    public static BufferedImage[] playerRight;
    public static BufferedImage[] playerUp;
    public static BufferedImage[] playerDown;
    // Spell FireBall assets
    public static BufferedImage[] fireball;
    public static BufferedImage[] fireballLeft;
    public static BufferedImage[] fireballRight;
    public static BufferedImage[] fireballUp;
    public static BufferedImage[] fireballDown;
    public static BufferedImage[] fireballDownLeft;
    public static BufferedImage[] fireballDownRight;
    public static BufferedImage[] fireballUpLeft;
    public static BufferedImage[] fireballUpRight;

    public static BufferedImage[] getAssets1() {
        return assets1;
    }

    public static int[][] getMap1() {
        return map1;
    }

    public static void init() {
        // player assets
        spriteLoader = new SpriteLoader("/1.png");
        player = spriteLoader.getTailSet();
        playerDown = new BufferedImage[]{player[0], player[1], player[2]};
        playerRight = new BufferedImage[]{player[24], player[25], player[26]};
        playerUp = new BufferedImage[]{player[36], player[37], player[38]};
        playerLeft = new BufferedImage[]{player[12], player[13], player[14]};
        // mage assets
        mageDown = new BufferedImage[]{player[48], player[49], player[50]};
        mageLeft = new BufferedImage[]{player[60], player[61], player[62]};
        mageRight = new BufferedImage[]{player[72], player[73], player[74]};
        mageUp = new BufferedImage[]{player[84], player[85], player[86]};

// fireball assets
        spriteLoader = new SpriteLoader("/fireball.png");
        fireball = spriteLoader.getTailSet();
        fireballLeft = new BufferedImage[]{fireball[0],fireball[1],fireball[2],fireball[3],fireball[4],fireball[5],fireball[6],fireball[7]};
        fireballUpLeft = new BufferedImage[]{fireball[8],fireball[9],fireball[10],fireball[11],fireball[12],fireball[13],fireball[14],fireball[15]};
        fireballUp = new BufferedImage[]{fireball[16],fireball[17],fireball[18],fireball[19],fireball[20],fireball[21],fireball[22],fireball[23]};
        fireballUpRight = new BufferedImage[]{fireball[24],fireball[25],fireball[26],fireball[27],fireball[28],fireball[29],fireball[30],fireball[31]};
        fireballRight = new BufferedImage[]{fireball[32],fireball[33],fireball[34],fireball[35],fireball[36],fireball[37],fireball[38],fireball[39]};
        fireballDownRight = new BufferedImage[]{fireball[40],fireball[41],fireball[42],fireball[43],fireball[44],fireball[45],fireball[46],fireball[47]};
        fireballDown = new BufferedImage[]{fireball[48],fireball[49],fireball[50],fireball[51],fireball[52],fireball[53],fireball[54],fireball[55]};
        fireballDownLeft = new BufferedImage[]{fireball[56],fireball[57],fireball[58],fireball[59],fireball[60],fireball[61],fireball[62],fireball[63]};

        // lvl 1 assets load
        spriteLoader = new SpriteLoader("/2.png", "/2.map");

        assets1 = spriteLoader.getTailSet();
        map1 = spriteLoader.getMap();
        // lvl 2 assets load

    }


}
