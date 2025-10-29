import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            int n = getInt(input);
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

    public static String getFactor(int n) {
        int y = 2;
        int[] P = new int[(int) Math.sqrt(n)];

        for (int x = 0; x < P.length; x++) {
            P[x] = y;
            y++;
        }

        String f = "";
        for (int i : P) {
            while (n % i == 0) {
                f += i + ", ";
                n /= i;
            }
        }
        if (f == "") {
            f = String.valueOf(n);
        }
        return f;
    }

    public static int getInt(Scanner input) {
        System.out.print("Enter integer greater than 1 (0 to terminate): ");
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Not an integer; try again.");
            System.out.print("Enter integer greater than 1 (0 to terminate): ");
        }
        return input.nextInt();
    }
}
