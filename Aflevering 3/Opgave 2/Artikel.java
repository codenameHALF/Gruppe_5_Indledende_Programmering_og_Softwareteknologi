public class Artikel extends Tidsskrift {
    private String forfattere;
    private String[] referenceliste;
    private Tidsskrift tidsskrift;
    private String titel;

    public Artikel(String forfattere, String titel, Tidsskrift tidsskrift) {
        this.titel = titel;
        this.forfattere = forfattere;
        this.tidsskrift = tidsskrift;
    }

    public String toString(){
        return "- " + forfattere + ": " + "\"" + titel + "\"" + tidsskrift.getTitel(); 
    }

    public void setReferenceliste() {
  
    }

}
