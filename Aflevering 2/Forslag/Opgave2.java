import java.util.Scanner;

public class Opgave2 {

    public static void main(String[] args) {
        System.out.print("Enter line to check: ");
        Scanner scanner = new Scanner(System.in);
        String inString = scanner.nextLine();
        scanner.close();

        if (isPalindrome(inString)) {System.out.println("\"" + inString + "\" is a palindrome!");}
        else {System.out.println("\"" + inString + "\" is not a palindrome...");}
    }
 
    public static boolean isPalindrome(String inSentence) {
        String sentence = inSentence;
        sentence = sentence.replaceAll("\\s", "");
        sentence = sentence.toLowerCase().replace(",", "").replace(".", "");

        boolean result = true;
        for (int i = 0; i < sentence.length() / 2; i++) {
            if (sentence.charAt(sentence.length()-1-i) != sentence.charAt(i)) {result = false;}
        }
        
        return result;
    }

}
