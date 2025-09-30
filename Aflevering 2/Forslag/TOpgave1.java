import java.util.Scanner;

public class TOpgave1 {

    public static void main(String[] args) {
        System.out.print("Enter positive integer to convert: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();

        System.out.println(num + " = " + numToRoman(num));
    }


    public static String numToRoman(int num) {
        if (num < 1 | num >= 4000) {return "Invalid number";}
        String result = "";
        
        int n3, n2, n1, n0;
        n3 = (num % 10000) / 1000;
        n2 = (num % 1000) / 100;
        n1 = (num % 100) / 10;
        n0 = (num % 10) / 1;

        for(int i=0;i<n3;i++){result+="M";}

        if (n2 <= 3){for(int i=0;i<n2;i++){result+="C";}}
        else if (n2 == 4){result+="CD";}
        else if (n2 <= 8){result+="D";for(int i=0;i<n2-5;i++){result+="C";}}
        else if (n2 == 9){result+="CM";}

        if (n1 <= 3){for(int i=0;i<n1;i++){result+="X";}}
        else if (n1 == 4){result+="XL";}
        else if (n1 <= 8){result+="L";for(int i=0;i<n1-5;i++){result+="X";}}
        else if (n1 == 9){result+="XC";}

        if (n0 <= 3){for(int i=0;i<n0;i++){result+="I";}}
        else if (n0 == 4){result+="IV";}
        else if (n0 <= 8){result+="V";for(int i=0;i<n0-5;i++){result+="I";}}
        else if (n0 == 9){result+="IX";}
        
        return result;
    }
}
