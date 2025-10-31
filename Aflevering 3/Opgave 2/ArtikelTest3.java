public class ArtikelTest3 {
    public static void main(String[] args) {
        Forlag forlag1 = new Forlag("University Press", "Danmark");
        Forlag forlag2 = new Forlag("University Times", "Sverige");
        Forlag forlag3 = new Forlag("University Chronicles", "Letland");
        
        System.out.println(forlag1.toString());
        System.out.println(forlag2.toString());
        System.out.println(forlag3.toString());


        Tidsskrift tidsskrift1 = new Tidsskrift("brain Power");
        Tidsskrift tidsskrift2 = new Tidsskrift("Life Science");
        Tidsskrift tidsskrift3 = new Tidsskrift("Nature");

        tidsskrift1.setForlag(forlag3);
        tidsskrift2.setForlag(forlag1);
        tidsskrift3.setForlag(forlag2);

        tidsskrift2.setIssn("123312412");
        tidsskrift3.setIssn("4321");

        System.out.println(tidsskrift1.toString());
        System.out.println(tidsskrift2.toString());
        System.out.println(tidsskrift3.toString());

        System.out.println("Følgende artikler:");

        Artikel test3 = new Artikel("Anders And", "Anders And blad", tidsskrift1);
        Artikel test4 = new Artikel("A. Einstein", "Relativitetsteorien", tidsskrift2);
        Artikel artikel1 = new Artikel("D. Vader", "Dødstjernen", tidsskrift3);

        test3.setReferenceliste(new Artikel[] {test4});

        System.out.println(test3.toString());
        System.out.println(test4.toString());
        System.out.println(artikel1.toString());
        System.out.println();

        if (test3.hasReference(test4)) {System.out.println("Den første af disse artikler har en reference til den anden.");}
        if (test4.hasReference(test3)) {System.out.println("Den anden af disse artikler har en reference til den første.");}


    }
}
