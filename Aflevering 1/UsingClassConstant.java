public class UsingClassConstant {
    // This constant determines how many times +- is written each line
    public static final int SYMBOLS = 4;
    // This constant determines how many lines should be written
    public static final int LINES = 3;
    
    // Function for printing a square of + and -
    public static void main(String[] args) {
        for (int l=1; l<=LINES; l++){
            for (int j = 1; j <= SYMBOLS; j++) {
                System.out.print("+-");
            }
            System.out.println("+");
        }
    }
}