public class Artikeltest {
    public static void main(String[] args) {
        Forlag test = new Forlag("University Press", "Danmark");
        System.out.println(test.toString());
        Tidsskrift test2 = new Tidsskrift("Journal of logic");
        test2.setIssn("ISSN-nummeret kendes ikke.");
        test2.setForlag(test);
        System.out.println(test2.toString());

        System.out.println("Følgende to artikler:");
        Artikel test3 = new Artikel("A. Abe & A Turing", "A", test2);
        Artikel test4 = new Artikel("B. Bim", "B", test2);
        System.out.println(test3.toString());
        System.out.println(test4.toString());
    }
}
