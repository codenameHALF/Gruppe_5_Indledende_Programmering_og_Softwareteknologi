public class Remember {
    // her kalder vi vores tekst() metode to gange og printer "remember" mellem.
    public static void main(String[] args) {
        tekst();
        System.out.println("Remember:");
        tekst();
    }
    // en metode der printer den ønskede tekst.
    public static void tekst(){
        System.out.println("Use \"\\\\\" to obtain a \'backslash\' character.");
    }
}