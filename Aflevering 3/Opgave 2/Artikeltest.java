public class Artikeltest {
    public static void main(String[] args) {
        Forlag test = new Forlag("University Press", "Danmark");
        System.out.println(test.toString());
        Tidsskrift test2 = new Tidsskrift("Journal of logic");
        test2.setForlag(test);
        System.out.println(test2.toString());

        System.out.println("Følgende to artikler:");
        Artikel test3 = new Artikel("A. Abe & A Turing", "A", test2);
        Artikel test4 = new Artikel("B. Bim", "B", test2);
        test3.setReferenceliste(new Artikel[] {test4});
        System.out.println(test3.toString());
        System.out.println(test4.toString());
        System.out.println();

        if (test3.hasReference(test4)) {System.out.println("Den første af disse artikler har en reference til den anden.");}
        if (test4.hasReference(test3)) {System.out.println("Den anden af disse artikler har en reference til den første.");}

    }
}
