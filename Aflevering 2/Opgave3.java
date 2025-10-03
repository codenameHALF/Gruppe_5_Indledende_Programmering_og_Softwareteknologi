import java.util.*;
public class Opgave3 {
    // This program takes a line of user input from the command line in the form of a integer
    // The program will approximate pi using buffons needle
    static final Scanner scanner = new Scanner(System.in);
    static final Random rand = new Random();



    public static void main(String[] args) {
        // Get user input
        System.out.println("Enter number of iterations: ");
        int iterations = scanner.nextInt();
        scanner.close();

        // Now simulate buffons needle for each iteration
        int successes = 0;
        for (int i = 0; i<iterations; i++){
            double bot = rand.nextDouble()*2;
            double angle = rand.nextDouble()*180;
            double top = bot+Math.sin(Math.toRadians(angle));
            
            if (top >= 2){
                successes += 1;
            }
        }
        double pi = (double)iterations/successes;
        System.out.println(pi);
    }
}
