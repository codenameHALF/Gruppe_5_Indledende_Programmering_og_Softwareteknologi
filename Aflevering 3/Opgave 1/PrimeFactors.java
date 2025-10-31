import java.util.*;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // runs until the user inputs 0.
        while (true) {
            long n = getLong(input);
            if (n == 0) {
                break;
            }
            if (n < 0) {
                throw new IllegalArgumentException("Negative integer, Can't compute");
            }
            System.out.println("List of prime factors: " + getFactor(n));
            System.out.println();
        }
        System.out.println("Terminating...");
    }
    // gets the factors of the user input and returns them as String sperated på commas.
    public static String getFactor(long n) {
        List<Long> f = new LinkedList<>();
        //Finds factors from 2 and then every uneven number up to and including √n.
        // if it is a factor it is added to the list and n is divided by the number
        for (long i = 2; i <= Math.sqrt(n);) {
            if (n % i == 0) {
                f.add(i);
                n /= i;
            } else {
                i += (i == 2) ? 1 : 2;
            }
        }

        if (n > 1) {
            f.add(n);
        }
        //the list is converted to a String spaced out by ", "
        String factors = f.get(0).toString();

        for (int k = 1; k <= f.size() - 1; k++) {
            factors += ", " + f.get(k).toString();
        }

        return factors;
    }
    // returns a valid user input of the type long
    public static long getLong(Scanner input) {
        System.out.print("Enter integer greater than 1 (0 to terminate): ");
        while (!input.hasNextLong()) {
            input.next();
            System.out.println(
                    "The value you entered is either not an integer or it exceeds the max value of a long; try again.");
            System.out.println();
            System.out.print("Enter integer greater than 1 (0 to terminate): ");
        }
        return input.nextLong();
    }
}
