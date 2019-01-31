package AirportScheduler;

public class Flughafen {

    private Gate[] gates;
    private String name;

    public Flughafen() {
        this.name = "Gatwick";
        this.gates = new Gate[10];

        //nationale Gates
        gates[0] = new NationalesGate(1);
        gates[0].setFlug(new Flug(1, "13:00", "14:00", new Flugzeug(Flugzeug.PROP, "14:15", 150)));

        gates[1] = new NationalesGate(2);
        gates[1].setFlug(new Flug(2, "14:00", "15:00", new Flugzeug(Flugzeug.PROP, "15:15", 180)));

        gates[2] = new NationalesGate(3);
        gates[2].setFlug(new Flug(3, "15:00", "16:00", new Flugzeug(Flugzeug.PROP, "16:15", 100)));

        gates[3] = new NationalesGate(4);
        gates[3].setFlug(new Flug(4, "16:00", "17:00", new Flugzeug(Flugzeug.PROP, "17:15", 120)));


        //2 kleine internationale Gates
        gates[4] = new InternationalesGate(5, InternationalesGate.KLEIN);
        gates[4].setFlug(new Flug(1001, "17:00", "18:00", new Flugzeug(Flugzeug.PROP, "18:15", 200)));

        gates[5] = new InternationalesGate(6, InternationalesGate.KLEIN);
        gates[5].setFlug(new Flug(1002, "18:00", "19:00", new Flugzeug(Flugzeug.PROP, "19:15", 200)));


        //vier grosse internationale Gates
        gates[6] = new InternationalesGate(7, InternationalesGate.GROSS);
        gates[6].setFlug(new Flug(1003, "19:00", "20:00", new Flugzeug(Flugzeug.JET, "20:15", 200)));

        gates[7] = new InternationalesGate(8, InternationalesGate.GROSS);
        gates[7].setFlug(new Flug(1004, "20:00", "21:00", new Flugzeug(Flugzeug.JET, "21:15", 250)));

        gates[8] = new InternationalesGate(8, InternationalesGate.GROSS);
        gates[8].setFlug(new Flug(1005, "21:00", "22:00", new Flugzeug(Flugzeug.JET, "22:15", 250)));

        gates[9] = new InternationalesGate(8, InternationalesGate.GROSS);
        gates[9].setFlug(new Flug(1006, "22:00", "23:00", new Flugzeug(Flugzeug.JET, "23:15", 300)));

    }

    public int landen(Flug flug) {

        for (int i = 0; i < 10; i++) {
            if (gates[i].istFrei()) {       //Schleife über alle Gates
                if (flug.istNational()) {   //nur freie Gates
                    gates[i].landen(flug);  //nationaler Flug passt immer
                    return i + 1;
                } else {                    //internationaler Flug
                    if (gates[i] instanceof InternationalesGate && (gates[i]).getGroesse() == InternationalesGate.GROSS) {
                        gates[i].landen(flug);
                        return i + 1;
                    }
                }
            }
        }
        return -1;
    }

    public void starten(int gateNr) {

        if (!gates[gateNr - 1].istFrei()) {
            gates[gateNr - 1].starten();
        } else {
            System.out.println("Das Gate " + gateNr + " ist frei!\n");
        }

    }

    public void gateStatus(int gateNr) {

        Gate gate = gates[gateNr - 1];

        if (!gate.istFrei()) {
            String typ;
            String groesse;

            if (gate instanceof InternationalesGate) {
                typ = "Internationaler Gate";

                if (gate.getGroesse() == InternationalesGate.GROSS) {
                    groesse = "Grosser Gate";
                } else {
                    groesse = "Kleiner Gate";
                }

            } else {
                typ = "Nationaler Gate";
                groesse = "Kleiner Gate";
            }

            System.out.println("Nummer: " + gate.getNummer() + "\nGroesse: " + groesse + "\nTyp: " + typ);
        } else {
            System.out.println("Das Gate " + gateNr + " ist frei!\n");
        }
    }

    public Gate[] getGates() {
        return gates;
    }
}
