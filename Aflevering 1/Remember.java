public class Remember {
    // Her kalder vi vores tekst() metode to gange og printer "remember" mellem.
    public static void main(String[] args) {
        tekst();
        System.out.println("Remember:");
        tekst();
    }
    // En metode der printer den ønskede tekst.
    public static void tekst(){
        System.out.println("Use \"\\\\\" to obtain a \'backslash\' character.");
    }
}