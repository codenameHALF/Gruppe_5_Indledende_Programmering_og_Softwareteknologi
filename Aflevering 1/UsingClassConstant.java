public class UsingClassConstant {
    public static final int SYMBOLS = 2;
    public static final int LINES = 3;
    public static void main(String[] args) {
        for (int l=1; l<=LINES; l++){
            for (int i = 1; i <= SYMBOLS ; i++) {
                for (int j = 1; j <= SYMBOLS; j++) {
                    System.out.print("+-");
                }
            }
                System.out.println("+");
        }
    }
}

// Secret message