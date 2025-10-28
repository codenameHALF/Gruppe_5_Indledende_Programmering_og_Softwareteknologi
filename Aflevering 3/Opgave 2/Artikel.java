public class Artikel extends Tidsskrift {
    private String forfattere;
    private String[] referencelist;
    private Tidsskrift tidsskrift;

    public Artikel(String forfattere, String titel, Tidsskrift tidsskrift) {
        super(titel);
        this.forfattere = forfattere;
        this.tidsskrift = tidsskrift;
    }

    public void setReferenceliste() {

    }

}
