import java.util.*;
public class Opgave1 {
    // This program takes a line of user input from the command line in the form of an integer
    // The integer will then be converted to a roman numeral and printed back to the user
    public static void main(String[] args) {
        // Get user input
        System.out.print("Indtast tal:");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.close();

        // Print the result back
        System.out.println(Roman(num));
    }

    // This function takes an integer and outputs a string of its corresponding roman numeral
    public static String Roman(int num) {
        // Check if number is valid
        // Roman numerals can only describe numbers from 1 to 3999
        if (num < 1 | num > 3999){
            return "Invalid";
        }

        // Since we want to look at each digit seperately
        // We take the remainder from division of powers of 10 and divide it such that the target digit is isolated
        int n4, n3, n2, n1;
        n4 = num%10000/1000;
        n3 = num%1000/100;
        n2 = num%100/10;
        n1 = num%10/1;

        // The result is appended to the string "result"
        // By doing a series of checks the corresponding symbols to the digit are added to "result"
        // --------------------------- Check block starts here ---------------------------
        String result = ""; 
        
        // Checks for the 4'th digit
        for (int i = 0; i<n4; i++) {
            result += "M";
        }
        
        // Checks for the 3'rd digit
        if (n3<4) {
            for (int i = 0; i<n3; i++) {
                result += "C";
            }
        } else if (n3==4) {
            result += "CD";
        } else if (n3<=8) {
            result+="D"; 
            for(int i=0; i<n3-5; i++) {
                result+="C";
            }
        } else if (n3==9) {
            result += "CM";
        }
    
        // Checks for the 2'nd digit
        if (n2<4) {
            for (int i = 0; i<n2; i++) {
                result += "X";
            }
        } else if (n2==4) {
            result += "XL";
        } else if (n2<=8) {
            result+="L"; 
            for (int i=0; i<n2-5; i++) {
                result+="X";
            }
        } else if (n2==9) {
            result += "XC";
        }
        
        // Checks for the 1'st digit
        if (n1<4) {
            for (int i = 0; i<n1; i++) {
                result += "I";
            }
        } else if (n1==4) {
            result += "IV";
        } else if (n1<=8) {
            result+="V"; 
            for (int i=0; i<n1-5; i++) {
                result+="I";
            }
        } else if (n1==9) {
            result += "IX";
        }
        // --------------------------- Check block ends here ---------------------------

        return result;
    }
}