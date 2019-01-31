package AirportScheduler;

public class Flug {

    private int nummer;
    private String startzeit;
    private String landezeit;
    private Flugzeug flugzeug;

    public Flug(int nummer, String startzeit, String landezeit, Flugzeug flugzeug) {
        this.nummer = nummer;
        this.startzeit = startzeit;
        this.landezeit = landezeit;
        this.flugzeug = flugzeug;
    }

    public Flugzeug getFlugzeug() {
        return flugzeug;
    }

    public int getFlugnummer() {
        return nummer;
    }

    public String getStartzeit() {
        return startzeit;
    }

    public String getLandezeit() {
        return landezeit;
    }

    public boolean istNational() {
        return (nummer < 1000);
    }

}
