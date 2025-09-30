import java.util.Scanner;

public class Opgave1Old {

    public static final String[] chars = {"I", "V", "X", "L", "C", "D", "M", "_", "_"};

    public static void main(String[] args) {
        System.out.print("Enter positive integer to convert: ");
        Scanner scanner = new Scanner(System.in);
        String inString = scanner.next();
        scanner.close();

        System.out.println(inString + " = " + numToRoman(Integer.valueOf(inString)));
    }


    public static String numToRoman(int num) {
        if (num < 1 | num >= 4000) {return "Invalid number";}
        String result = "";
        
        for (int i = 0; i < Integer.toString(num).length(); i++) {
            int currentDigit = Character.getNumericValue(Integer.toString(num).charAt(i));
            int l = Integer.toString(num).length();
            String min = chars[(l-1-i)*2 + 0];
            String mid = chars[(l-1-i)*2 + 1];
            String max = chars[(l-1-i)*2 + 2];

            if (currentDigit == 0) {continue;}
            if (currentDigit <= 3) {for (int j = currentDigit; j > 0; j--) {result += min;} continue;}
            if (currentDigit == 4) {result += min + mid; continue;}
            if (currentDigit <= 8) {result += mid; for (int j = currentDigit-5; j > 0; j--) {result += min;} continue;}
            if (currentDigit == 9) {result += min + max; continue;}
        }
        return result;
    }
}
