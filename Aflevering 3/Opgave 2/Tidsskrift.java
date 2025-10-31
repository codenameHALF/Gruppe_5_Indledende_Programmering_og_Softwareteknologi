
public class Tidsskrift {
    private String titel;
    private String issn;
    private Forlag forlag;

    public Tidsskrift(String titel) {
        this.titel = titel;
    }

    public Tidsskrift() {
        this.titel = "";
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public void setForlag(Forlag forlag) {
        this.forlag = forlag;
    }

    public String getTitel(){
        return titel;
    }

    public String toString() {
        if (issn == null){
            return "Tidsskriftet " + titel + ". Dette tidsskrift kommer fra " + forlag + ". ISSN-numrene kendes ikke.";
        }
        return "Tidsskriftet " + titel + ". Dette tidsskrift kommer fra " + forlag +". " + issn;
    }
}
