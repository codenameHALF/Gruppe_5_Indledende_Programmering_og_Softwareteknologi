import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.awt.*;


public class Mandelbrot {
    
    public static int MAX = 255;
    public static int GRIDRES = 512;
    public static Complex c = new Complex(0.10259, -0.604);
    public static double s = 0.0086;
    public static Color[] palette;
    public static String palettePath = "mnd/blues.mnd";


    public static void main(String[] args) {
        palette = readMnd(palettePath);
        draw();
    }

    public static Color[] readMnd(String path) {
        Color[] newPalette = new Color[256];
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            int i = 0;
            while (scanner.hasNextInt()) {
                int r = scanner.nextInt();
                int g = scanner.nextInt();
                int b = scanner.nextInt();
                newPalette[i] = new Color(r, g, b);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return newPalette;

    }

    public static void draw() {
        StdDraw.setXscale(0,GRIDRES);
        StdDraw.setYscale(0,GRIDRES);
        //StdDraw.setCanvasSize(1000,1000);
        StdDraw.setPenRadius(1.0/GRIDRES);
        StdDraw.show(0);
        for (int k = 0; k < GRIDRES; k++) {
            for (int j = 0; j < GRIDRES; j++) {
                Complex point = gridComplex(j, k);
                int iterations = iterate(point);
                StdDraw.setPenColor(palette[iterations]);
                StdDraw.point(j+0.5, k+0.5);
            }
        }
        StdDraw.show(0);
    }

    public static int iterate(Complex z0) {
        Complex z = new Complex(z0);
        for (int i = 0; i < MAX; i++) {
            if (z.abs() > 2.0) {
                return i;
            }
            z = z.times(z).plus(z0);
        }
        return MAX;
    }

    public static Complex gridComplex(int j, int k) {
        double newRe = c.getRe() - (s / 2) + (s * j) / (GRIDRES - 1);
        double newIm = c.getIm() - (s / 2) + (s * k) / (GRIDRES - 1);
        return new Complex(newRe, newIm);
    }
}
