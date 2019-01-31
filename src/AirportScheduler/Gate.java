package AirportScheduler;

public class Gate {


    public static final int NATIONAL = 0;
    public static final int INTERNATIONAL = 1;

    private int typ;
    private int groesse;
    private int nummer;
    private Flug flug;

    public Gate(int nummer){
        this.nummer = nummer;
    }

    public Gate(int nummer, int typ, int groesse)
    {
        super();
        this.typ = typ;
        this.groesse = groesse;
        this.nummer = nummer;
    }

    public void landen(Flug flug) {
        this.flug = flug;
    }

    public void starten() {
        this.flug = null;
    }

    public boolean istFrei() {
        return (this.flug == null);
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setFlug(Flug flug) {
        this.flug = flug;
    }

    public int getTyp() {
        return typ;
    }

    public int getGroesse() {
        return groesse;
    }

    public int getNummer() {
        return nummer;
    }

    public Flug getFlug() {
        return flug;
    }

    public Flugzeug getFlugzeug() {
        if (this.flug == null) {
            return null;
        }
        return flug.getFlugzeug();
    }
}
