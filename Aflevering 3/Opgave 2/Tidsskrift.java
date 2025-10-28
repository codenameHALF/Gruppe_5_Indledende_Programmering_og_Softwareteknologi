
public class Tidsskrift extends Forlag {
    private String titel;
    private String issn;

    public Tidsskrift(String titel){
        this.titel = titel;
    }
    public void setIssn(String issn){
        this.issn = issn;
    }
    public void setForlag(new Forlag(String navn, String sted)){
        super(navn);
        super(sted);
    }
}
