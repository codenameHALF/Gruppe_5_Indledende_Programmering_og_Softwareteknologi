import java.util.*;
import java.io.*;
import java.awt.*;


// This class renders an image of an approximation of the mandelbrott set
public class Mandelbrot {
    public static double cRe;
    public static double cIm;
    public static double s;
    public static Complex c;
    // Maximal iterations (cannot be over 255 because of compatability)
    public static int MAX = 255;
    // Resolution of render
    public static int GRIDRES = 512;
    public static Color[] palette;
    // Path to palette file
    public static String palettePath = "mnd/blues.mnd";


    //Take user input and render image
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cRe = getNextDouble(scanner, "Enter center real coordinate: ");
        cIm = getNextDouble(scanner, "Enter center imaginary coordinate: ");
        c = new Complex(cRe, cIm);
        s = getNextDouble(scanner, "Enter size of view: ");
        scanner.close();
        palette = readMnd(palettePath);
        draw();
    }

    // Read mnd file and convert to palette array
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

    // Render image
    public static void draw() {
        StdDraw.setXscale(0,GRIDRES);
        StdDraw.setYscale(0,GRIDRES);
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

    // Does the same operation to a complex number z0 MAX amount of times
    // The method returns the amount of iterations needed for the magnitude of z0 to exceed 2
    // If it never does so, MAX is simply returned
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

    // Gets complex number at column j and row k within specified area
    public static Complex gridComplex(int j, int k) {
        double newRe = c.getRe() - (s / 2) + (s * j) / (GRIDRES - 1);
        double newIm = c.getIm() - (s / 2) + (s * k) / (GRIDRES - 1);
        return new Complex(newRe, newIm);
    }

    // Gets a double from the user
    public static double getNextDouble(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println("Error: please provide a value of type double");
            System.out.print(message);
        }
        return scanner.nextDouble();
    }
}
