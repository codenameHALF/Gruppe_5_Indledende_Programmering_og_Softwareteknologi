import java.util.*;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            long n = getLong(input);
            if (n == 0) {
                break;
            }
            if (n < 0) {
                throw new IllegalArgumentException("Negative integer, Can't compute");
            }
            System.out.println("List of prime factors: " + getFactor(n));
        }
        System.out.println("Terminating...");
    }

    public static String getFactor(long n) {


        List<Long> f = new LinkedList<>();

        for (long i = 2; i * i <= n;i++) {
            while (n % i == 0) {
                f.add(i);
                n /= i;
            }
        }

        if (f.isEmpty()){
            f.add(n);
        }
        
        String factors = f.get(0).toString();
        for (int k = 1; k <= f.size()-1; k++){
            factors += ", " + f.get(k).toString();
        }

        return factors;
    }

    public static long getLong(Scanner input) {
        System.out.print("Enter integer greater than 1 (0 to terminate): ");
        while (!input.hasNextLong()) {
            input.next();
            System.out.println("Not an integer; try again.");
            System.out.print("Enter integer greater than 1 (0 to terminate): ");
        }
        return input.nextLong();
    }
}
