package AirportScheduler;

import java.util.Scanner;

public class Menu {

    private Flughafen flughafen;

    public Menu() {
        flughafen = new Flughafen();
    }

    private void show() {
        System.out.println("Airport Scheduler Hauptmenü");
        System.out.println("===========================\n");
        System.out.println("1. Landen");
        System.out.println("2. Starten");
        System.out.println("3. Gatedaten\n");
        System.out.println("4. Ende");
    }

    public void choose() {

        while (true) {
            show();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ihre Wahl: ");

            try {
                int eingabe = scanner.nextInt();

                switch (eingabe) {
                    case 1:
                        System.out.print("\nGeben Sie die Flugnummer (1 - 10): ");
                        int flugNummer = scanner.nextInt();

                        if (flugNummer < 1 || flugNummer > 10) {
                            System.out.print("\nKorrigieren Sie Ihre Eingabe: ");

                            while (flugNummer < 1 || flugNummer > 10) {
                                System.out.print("\nKorrigieren Sie Ihre Eingabe: ");
                                flugNummer = scanner.nextInt();
                            }
                        }

                        landen(flugNummer);
                        break;
                    case 2:

                        for (int i = 1; i <= flughafen.getGates().length; i++) {
                            if (!flughafen.getGates()[i - 1].istFrei()) {
                                System.out.println("Gate " + i + ") " + flughafen.getGates()[i - 1].getFlug().getStartzeit());
                            } else {
                                System.out.println("Gate " + i + ") Frei");
                            }
                        }

                        System.out.print("\nWählen Sie ein Gate aus (1 - 10): ");
                        int gateNummer = scanner.nextInt();

                        if (gateNummer < 1 || gateNummer > 10 || flughafen.getGates()[gateNummer - 1].istFrei()) {

                            System.out.print("\nKorrigieren Sie Ihre Eingabe: ");

                            while (gateNummer < 1 || gateNummer > 10 || flughafen.getGates()[gateNummer - 1].istFrei()) {
                                System.out.print("\nKorrigieren Sie Ihre Eingabe: ");
                                gateNummer = scanner.nextInt();
                            }
                        }

                        starten(gateNummer);
                        break;
                    case 3:
                        System.out.print("\nWählen Sie ein Gate aus (1 - 10): ");
                        int gatenummer = scanner.nextInt();

                        if (gatenummer < 1 || gatenummer > 10) {
                            System.out.print("\nKorrigieren Sie Ihre Eingabe: ");

                            while (gatenummer < 1 || gatenummer > 10) {
                                System.out.print("\nKorrigieren Sie Ihre Eingabe: ");
                                gatenummer = scanner.nextInt();
                            }
                        }

                        flughafen.gateStatus(gatenummer);
                        break;
                    case 4:
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Ungueltige Wahl");
                }

            } catch (Exception e) {
                System.out.println("Ein Fehler ist aufgetreten!");
            }
        }
    }

    private void landen(int flugnummer) {

        System.out.println("\nLanden...\n");

        flughafen.landen(flughafen.getGates()[flugnummer - 1].getFlug());

        System.out.println("Maschine ist an Gate " + flughafen.getGates()[flugnummer - 1].getNummer() + " gelandet");
    }

    private void starten(int gateNummer) {

        System.out.println("\nStarten...\n");

        flughafen.starten(gateNummer);

        System.out.println("Das Flugzeug konnte erfolgreich starten!\n");
    }
}
