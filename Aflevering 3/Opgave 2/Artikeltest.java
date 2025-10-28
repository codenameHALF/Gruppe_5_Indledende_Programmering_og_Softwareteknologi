public class Artikeltest {
    public static void main(String[] args) {
        Forlag test = new Forlag("Gyldendal", "Danmark");
        System.out.println(test.toString());
        Tidsskrift test2 = new Tidsskrift("Times");
        test2.setIssn("1234");
        Forlag placeholder = new Forlag("hat", "ged");
        test2.setForlag(placeholder);
        System.out.println(test2.toString());
    }
}
