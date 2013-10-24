package net.xaviersala.barcos;

import java.util.ArrayList;

/**
 * Classe principal que fa que juguin dos jugadors a la
 * guerra de barcos.
 *
 * Ho fan automàticament
 *
 * @author Xavier
 *
 */
public class Principal {


    /**
     * Número de jugadors que juguen.
     */
    public static final int JUGADORS  = 2;

    /**
     * Número de barcos de cada jugador.
     */
    public static final int NUMERODEBARCOS = 2;

    /**
     * Amplada del tauler dels jugadors.
     */
    public static final int AMPLADATAULER = 5;

    /**
     * Altura del tauler dels jugadors.
     */
    public static final int ALTURATAULER = 5;

    /**
     *
     */
    public static final String[] NOMSJUGADORS = {"Pere", "Pau"};

    /**
     * Funció que se n'encarrega d'assignar barcos a cada un dels
     * jugadors. Ho fa entre els barcos de la taula que he creat
     * per a fer-ho.
     *
     * @param jugador Jugador que tria
     */
    public static void posarBarcos(final Jugador jugador) {

        String[][] llistaBarcos = {{"A1", "A2" }, {"B1", "B2", "B3" },
                {"A3", "B3", "C3"}, {"E1", "E2"}, {"A4", "B4", "C4" },
                {"C3", "D3", "E3"}, {"A1", "B1"}, {"C2", "C3", "C4" },
                {"B0", "C0", "D0"} };

        System.out.println("----------- "
                           + NUMERODEBARCOS
                           + " BARCOS ---------------");
        String respostaJugador = "";

        for (int i = 0; i < NUMERODEBARCOS; i++) {
            String[] candidat;
            do {
                int aleatori = (int) (Math.random() * llistaBarcos.length);
                candidat = llistaBarcos[aleatori];
                respostaJugador = jugador.posaBarco(candidat);
                System.out.println("... jugador " + jugador.getNom()
                        + " prova de posar un barco .. "
                        + respostaJugador);
            } while(respostaJugador != "OK");

            System.out.println("........... jugador " + jugador.getNom()
                    + " posa  barco a " + imprimeixBarco(candidat));

        }
    }

    /**
     * Imprimeix el candidat a barco que s'ha especificat.
     *
     * @param candidat Barco que es vol incloure
     * @return Cadena amb el barco a imprimir
     */
    private static String imprimeixBarco(final String[] candidat) {

        String resultat = "";
        for (String s: candidat) {
            resultat += s + " ";
        }
        return resultat;
    }

    /**
     * Programa principal.
     *
     * @param args No es fa servir.
     */
    public static void main(final String[] args) {

        ArrayList<Jugador> jugadors = new ArrayList<Jugador>();

        for (int i = 0; i < JUGADORS; i++) {
            jugadors.add(new Jugador(NOMSJUGADORS[i]));
            Tauler t = new Tauler(AMPLADATAULER, ALTURATAULER);
            jugadors.get(jugadors.size() - 1).agafaTauler(t);
            posarBarcos(jugadors.get(i));
        }

        System.out.println("-------------------------------------");
        System.out.println("           COMENÇA EL JOC            ");
        System.out.println("-------------------------------------");
        int jugadorQueEscull = 0;
        int jugadorQueEspera = 1;

        while (!jugadors.get(0).haPerdut()
               && !jugadors.get(1).haPerdut()) {

            String tria = jugadors.get(jugadorQueEscull).endevinaBarco();
            String resultatRecerca = jugadors.get(jugadorQueEspera).comprovaSiHiHaBarcoA(tria);
            System.out.println(jugadors.get(jugadorQueEscull).getNom()
                    + ": " + tria + " --> " + resultatRecerca);

            // Separar el nom del jugador de la resposta
            String[] resultat = resultatRecerca.split(" : ");

            if (resultat[1].equals("aigua")) {
                jugadorQueEspera = jugadorQueEscull;
                jugadorQueEscull = (jugadorQueEscull + 1) % JUGADORS;
            }

        }
    }

}
