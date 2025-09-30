import java.util.Random;
import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) {
        System.out.print("Enter number of iterations: ");
        
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        scanner.close();
        int successes = 0;
        
        for (int i = 0; i < iterations; i++) {
            double bottom = 2 * r.nextDouble();
            double angle = 180 * r.nextDouble();
            double top = Math.sin(Math.toRadians(angle)) + bottom;
            if (top > 2) {successes++;}
        }
        System.out.print(String.valueOf(iterations) + " / " + String.valueOf(successes) + " = ");
        System.out.println((double) iterations / successes);
    }
}