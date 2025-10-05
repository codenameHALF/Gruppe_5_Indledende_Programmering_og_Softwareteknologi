import java.util.*;
// This program takes a line of user input from the command line in the form of an integer "n"
// The program will then perfom a random walk on an n*n grid until it walks off its borders
public class Opgave4 {
    static final Scanner input = new Scanner(System.in);
    static final Random rand = new Random();

    public static void main(String[] args) {
        // Get user input
        int n = getInt(input);

        if (n < 0) {
            throw new IllegalArgumentException("Negative integer, Can't compute");
        }

        int x = 0;
        int y = 0;
        int steps = 0;
        
        // Setup StdDraw
        StdDraw.setXscale(-n - 0.5, n + 0.5);
        StdDraw.setYscale(-n - 0.5, n + 0.5);
        StdDraw.setPenRadius(1.0 / (n * 2 + 1));

        // Do random walk
        while (Math.abs(x) <= n && Math.abs(y) <= n) {
            StdDraw.point(x, y);

            int move = rand.nextInt(4);
            if (move == 0) {
                x++;
            } else if (move == 1) {
                x--;
            } else if (move == 2) {
                y++;
            } else if (move == 3) {
                y--;
            }

            System.out.println("Position = ("+ x + "," + y +")" );
            steps++;
        }
        System.out.println("Number of steps: " + steps);
    }

    // This method asks the user for input and returns it
    public static int getInt(Scanner input) {
        System.out.print("Enter grid size: ");
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Not an integer; try again.");
            System.out.print("Enter grid size: ");
        }
        return input.nextInt();
    }

}