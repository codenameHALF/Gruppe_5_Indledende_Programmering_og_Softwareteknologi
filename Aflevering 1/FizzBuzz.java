public class FizzBuzz {
    public static final int TAL = 30;
    public static void main(String[] args) {
        for (int i=1; i<=TAL; i++){
            //isFizzbuzz(i) ? fizzbuzz() : (isBuzz(i) ? buzz() : (isFizz(i) ? fizz() : print(String.valueOf(i))));
            System.out.println(isFizzbuzz(i));
        }
    }

    public static void print(String output) {
        System.out.println(output);
    }

    public static void fizz() {
        System.out.println("fizz");
    }
    
    public static void buzz() {
        System.out.println("buzz");
    }

    public static void fizzbuzz() {
        System.out.println("fizzbuzz");
    }

    public static boolean isFizz(int i) {
        return i % 3 == 0;
    }
    
    public static boolean isBuzz(int i) {
        return i % 5 == 0;
    }

    public static boolean isFizzbuzz(int i) {
        return i % 15 == 0;
    }
}
            