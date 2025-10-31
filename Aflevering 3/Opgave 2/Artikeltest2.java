public class ArtikelTest2 {
    public static void main(String[] args) {
        Forlag test = new Forlag("Gyldendal", "Danmark");
        System.out.println(test.toString());
        Tidsskrift test2 = new Tidsskrift("Times");
        test2.setIssn("214532532");
        test2.setForlag(test);
        System.out.println(test2.toString());

        System.out.println("Følgende artikel:");
        Artikel test3 = new Artikel("O. Sprogøe & L. Nørgaard", "Matador", test2);
        System.out.println(test3.toString());
        System.out.println();
        System.out.println("Denne artikel har ingen referencer");

        //if (test3.hasReference()) {System.out.println("Den første af disse artikler har en reference til den anden.");}
        //if (test4.hasReference()) {System.out.println("Den anden af disse artikler har en reference til den første.");}


    }
}
