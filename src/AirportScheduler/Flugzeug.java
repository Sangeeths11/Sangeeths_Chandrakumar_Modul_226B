package AirportScheduler;

import java.util.ArrayList;

public class Flugzeug {

    public static final int PROP = 0;
    public static final int JET = 1;

    public int typ;
    public String nachtankzeit;
    public int kapazitaet;

    public Flugzeug(int typ, String nachtankzeit, int kapazitaet) {
        this.typ = typ;
        this.nachtankzeit = nachtankzeit;
        this.kapazitaet = kapazitaet;
    }
}
