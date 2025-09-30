import java.util.*;
public class Opgave3 {
    public static void main(String[] args) {
        System.out.println("Enter number of iterations: ");

        Random rand = new Random();    
        Scanner scanner = new Scanner(System.in);
        int successes = 0;
        int iterations = scanner.nextInt();
    
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
