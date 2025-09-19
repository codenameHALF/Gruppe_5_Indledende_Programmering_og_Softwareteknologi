public class FizzBuzz {
    // This constant determines how many times the loop is run
    public static final int N = 30;

    // This function prints numbers from 1 to 30
    // If a number is fully divisible by 3, 5 or 15
    // the program will instead print fizz, buzz or fizzbuzz
    public static void main(String[] args) {
        // This loop runs from 1 to N
        for (int i=1; i<=N; i++){
            // The string result is initially set to the value of i
            String result = String.valueOf(i);
            // If i is fully divisible by 3, 5 or 15 the result is updated
            // To either fizz, buzz or fizzbuzz
            result = i % 3 == 0 ? "fizz" : result;
            result = i % 5 == 0 ? "buzz" : result;
            result = i % 15 == 0 ? "fizzbuzz" : result;
            // The result is printed in the terminal for each iteration
            System.out.println(result);

        }
    }
}
            