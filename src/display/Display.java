package display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame jFrame;
    private Canvas canvas;
    private String title;
    public static int width,height;

    public Display(String title, int width, int height) {
        this.title = title;
        Display.width = width;
        Display.height = height;
        lunchDisplay();
    }

    private void lunchDisplay() {
        jFrame = new JFrame(title);
        jFrame.setSize(width,height);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        canvas = new Canvas();
        canvas.setSize(new Dimension(width,height));
        jFrame.add(canvas);
        jFrame.pack();

    }

    public Canvas getCanvas() {
        return canvas;
    }
}
