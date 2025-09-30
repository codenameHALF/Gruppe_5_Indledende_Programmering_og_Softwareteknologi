import java.util.Scanner;
import java.util.Random;

public class Opgave4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter size of grid: ");
        int n;
        
        try {
            n = s.nextInt();
        } catch (Exception e) {
            s.close();
            System.out.println("Invalid number, terminating...");
            return;
        }

        s.close();
        if (n < 0) {
            System.out.println("Invalid number, terminating...");
            return;
        }
        System.out.println();

        int posX, posY, steps;
        posX = posY = steps = 0;
        StdDraw.setXscale(-n-0.5, n+0.5);
        StdDraw.setYscale(-n-0.5, n+0.5);
        StdDraw.setPenRadius(1.0/(n*2+1));

        while (Math.abs(posX) <= n && Math.abs(posY) <= n) {
            StdDraw.point(posX, posY);
            int move = r.nextInt(4);
            switch (move) {
                case 0:
                    posX++;
                    break;
                case 1:
                    posX--;
                    break;
                case 2:
                    posY++;
                    break;
                case 3:
                    posY--;
                    break;
            }
            //System.out.println("Position = (" + posX + "," + posY + ")");
            steps++;
        }
        System.out.println("\nTotal number of staps = " + steps);


    }
}