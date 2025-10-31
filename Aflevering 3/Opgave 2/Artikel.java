public class Artikel extends Tidsskrift {
    private String forfattere;
    private Artikel[] referenceListe = new Artikel[0];
    private Tidsskrift tidsskrift;
    private String titel;

    public Artikel(String forfattere, String titel, Tidsskrift tidsskrift) {
        this.titel = titel;
        this.forfattere = forfattere;
        this.tidsskrift = tidsskrift;
    }

    public String toString(){
        return "- " + forfattere + ": " + "\"" + titel + "\"." + tidsskrift.getTitel() + "."; 
    }

    public void setReferenceliste(Artikel[] referenceListe) {
        this.referenceListe = referenceListe;
    }


    public boolean hasReference(Artikel sArtikel) {
        for (Artikel artikel : this.referenceListe) {
            if (artikel == sArtikel) {return true;}
        }
        return false;
    }

    public Artikel[] getReference(){
        return this.referenceListe;
    }

}
