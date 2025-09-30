import java.util.*;
public class Opgave1 {
    public static void main(String[] args) {
        System.out.print("Indtast tal:");
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        s.close();
        System.out.println(Roman(num));
    }
    public static String Roman(int num) {
    if (num < 1 | num > 3999){
        return "Invalid";
    }
    int n1, n10, n100, n1000;
    n1 = num%10/1;
    n10 = num%100/10;
    n100 = num%1000/100;
    n1000 = num%10000/1000;

    String Result = ""; 
    for (int i = 0; i<n1000; i++){Result += "M";}
    
    if (n100<4){for (int i = 0; i<n100; i++){Result += "C";}}
    else if (n100==4){Result += "CD";}
    else if (n100<=8){Result+="D"; for(int i=0; i<n100-5; i++){Result+="C";}}
    else if (n100==9){Result += "CM";}
   
    if (n10<4){for (int i = 0; i<n10; i++){Result += "X";}}
    else if (n10==4){Result += "XL";}
    else if (n10<=8){Result+="L"; for(int i=0; i<n10-5; i++){Result+="X";}}  
    else if (n10==9){Result += "XC";}
    
    if (n1<4){for (int i = 0; i<n1; i++){Result += "I";}}
    else if (n1==4){Result += "IV";}
    else if (n1<=8){Result+="V"; for(int i=0; i<n1-5; i++){Result+="I";}}
    else if (n1==9){Result += "IX";}

    return Result;
    }
}