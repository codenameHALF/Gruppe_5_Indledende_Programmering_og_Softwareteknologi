import java.util.*;

public class Opgave2 {
    // This program takes a line of user input from the command line in the form of a string
    // The program will check if the given string is a palindrom
    public static void main(String[] args) {
        // Get user input
        System.out.print("Enter line to check: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        input.close();

        // Print the result by evaluating the isPalindrome method
        if (isPalindrome(text)){
            System.out.println("\"" + text +"\" is a palindrome!");
        } else {
            System.out.println("Is not a palindrome");
        }
    }

    // This function takes a string "text" and returns a boolean value indicating if the string is a palindrom
    public static boolean isPalindrome(String text){
        // We start by formatting the string such that it only contains the relevant characters
        text = text.toLowerCase();
        text = text.replace(".", "");
        text = text.replace(",", "");
        text = text.replace(" ", "");

        // Now we make a new string corresponding to "text" mirrored
        String s = "";
        for (int i = 0; i < text.length(); i++){
            char r = text.charAt(i);
            s = r + s;
        }

        // Finally we can evaluate if the mirror verision matches the non-mirror
        return s.equals(text);

    }
}
