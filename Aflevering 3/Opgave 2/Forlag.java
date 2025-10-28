public class Forlag {
    private String navn;
    private String sted;

    public Forlag(String navn, String sted) {
        this.navn = navn;
        this.sted = sted;
    }

    public Forlag() {
        this.navn = "";
        this.sted = "";
    }

    public String toString() {
        return "Forlaget " + navn + ", " + sted;
    }
}