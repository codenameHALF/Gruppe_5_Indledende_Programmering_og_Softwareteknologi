public class Remember {
    // Here we call our text() method twice and print "remember" in between
    // This makes us able to reuse the text method which scales better
    public static void main(String[] args) {
        text();
        System.out.println("Remember:");
        text();
    }
    // A method that prints the wanted text
    public static void text(){
        System.out.println("Use \"\\\\\" to obtain a \'backslash\' character.");
    }
}