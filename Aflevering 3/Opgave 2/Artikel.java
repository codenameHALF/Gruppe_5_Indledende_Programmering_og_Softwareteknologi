public class Artikel extends Tidsskrift {
    private String forfattere;
    private String[] referenceListe = new String[0];
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

    public void setReferenceliste(String[] referenceListe) {
        this.referenceListe = referenceListe;
    }


    public boolean hasReference(String sTitle) {
        for (String title : this.referenceListe) {
            if (title == sTitle) {return true;}
        }
        return false;
    }

    public String[] getReference(){
        return this.referenceListe;
    }

}
