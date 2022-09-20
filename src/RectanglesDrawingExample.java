import javax.swing.*;
import java.awt.*;
import java.util.*;

public class RectanglesDrawingExample extends JFrame {


    public RectanglesDrawingExample() {
        super("Rectangles Drawing Demo");

        getContentPane().setBackground(Color.WHITE);
        setSize(512, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    void drawRectangles(Graphics g) {
        String secretNumber = Secret.getSecretNumber();


        char[] arrayC = secretNumber.toCharArray();
        double[] array = new double[arrayC.length];
        for (int i = 0; i < arrayC.length; i++) {
            array[i] = Double.parseDouble(String.valueOf(arrayC[i]));
        }
        Graphics2D g2d = (Graphics2D) g;
        int totalPossiblePixels = secretNumber.length() / 7;

        ArrayList<Pixel> allPixels = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i += 7) {
            try {
                allPixels.add(new Pixel((int)(254 * (array[i]/9)), (int)(254 * (array[i+1]/9)), (int)(254 * (double)(array[i+2]/9)),(int) (512 * array[i+3]/10), (int)(512 * array[i+4]/10), (int)(10 * array[i + 5]), (int)(10 * array[i + 6])));

            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }


        for (int i = 0; i < totalPossiblePixels; i++) {
            g2d.setColor(new Color(allPixels.get(i).r, allPixels.get(i).g, allPixels.get(i).b));
            g2d.fill(new Rectangle(allPixels.get(i).x, allPixels.get(i).y, allPixels.get(i).l, allPixels.get(i).w));

        }
    }


    public void paint(Graphics g) {
        super.paint(g);

        drawRectangles(g);
    }

    public static void main() throws Exception {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RectanglesDrawingExample().setVisible(true);
            }
        });
    }
}

/*void drawRectangles(Graphics g, String secretNumber) {
        char[] array = secretNumber.toCharArray();
        Graphics2D g2d = (Graphics2D) g;
        int totalPossiblePixels = secretNumber.length() / 9;
        int rows = (int) Math.sqrt(totalPossiblePixels);
        List<Pixel> allPixels = new ArrayList<>();

        for (int i = 0; i < totalPossiblePixels; i += 7) {
            allPixels.add(new Pixel(255 * array[i], 255 * array[i + 1], 255 * array[i + 2], 10 * array[i + 3], 10 * array[i + 4], 10 * array[i + 5], 10 * array[i + 6]));
        }

        for (int i = 0; i < totalPossiblePixels; i++) {
            g2d.setColor(new Color(allPixels.get(i).r, allPixels.get(i).g, allPixels.get(i).b));
            g2d.draw(new Rectangle(allPixels.get(i).x, allPixels.get(i).y, 100, 100));

        }


    }*/