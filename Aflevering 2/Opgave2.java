import java.util.*;

public class Opgave2 {
    public static void main(String[] args) {
        System.out.print("Enter line to check:");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        input.close();

        if (palindromeCheck(text)){
            System.out.println("\"" + text +"\" is a palindrome!");
        } else {
            System.out.println("Is not a palindrome");
        }
        

    }
    public static boolean palindromeCheck(String text){

        text = text.toLowerCase();
        text = text.replace(".", "");
        text = text.replace(",", "");
        text = text.replace(" ", "");

        String s = "";

        for (int i = 0; i < text.length(); i++){
            
            char r = text.charAt(i);
            s = r + s;
        }

        return s.equals(text);
         
    }
}
