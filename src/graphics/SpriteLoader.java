package graphics;

import display.Display;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class SpriteLoader {
    private BufferedImage sheet;
    private BufferedImage background;
    private BufferedImage[] tailSet;
    private final int TAIL_SIZE = 32;
    private int[][] map;
    private int numCols;
    private int numRows;
    private int numRowsToDraw;
    private int numColsToDraw;
    private int numTails;


    public SpriteLoader(String imgPath, String mapPath) {
        try {
            sheet = ImageIO.read(getClass().getResourceAsStream(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        int numRowsToDraw = Display.width / TAIL_SIZE;
        int numColsToDraw = Display.height / TAIL_SIZE;
        loadMap(mapPath);
        splitSheet();
        generateBackground();
    }

    private void splitSheet() {

    }

    private void loadMap(String mapPath) {
        InputStream in = getClass().getResourceAsStream(mapPath);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        try {
            numCols = Integer.parseInt(br.readLine());
            numRows = Integer.parseInt(br.readLine());
            map = new int[numCols][numRows];

            String delims = ",";
            for (int row = 0; row < numRows; row++) {
                String line = br.readLine();
                String[] tokens = line.split(delims);
                for (int col = 0; col < numCols; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public BufferedImage[] getTailSet() {
        return tailSet;
    }

    public int[][] getMap() {
        return map;
    }

    private void generateBackground() {
        int numTilesCol = sheet.getWidth() / TAIL_SIZE;
        int numTilesRow = sheet.getHeight() / TAIL_SIZE;
        numTails = numTilesCol * numTilesRow;
        tailSet = new BufferedImage[numTilesCol * numTilesRow];
        int couner = 0;
        for (int row = 0; row < numTilesRow; row++) {
            for (int col = 0; col < numTilesCol; col++) {
                tailSet[couner] = sheet.getSubimage(col * 32, row * 32, TAIL_SIZE, TAIL_SIZE);
                couner++;

            }
        }



    }
}
