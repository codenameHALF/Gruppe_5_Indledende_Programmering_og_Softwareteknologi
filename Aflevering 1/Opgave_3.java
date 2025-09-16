public class Opgave_3 {
    public static final int LINES = 2;
    public static void main(String[] args) {
        for (int l=1; l<=3; l++){
            for (int i = 1; i <= LINES ; i++) {
                for (int j = 1; j <= LINES; j++) {
                    System.out.print("+-");
                }
            }
                System.out.println("+");
        }
    }
}

// Secret message