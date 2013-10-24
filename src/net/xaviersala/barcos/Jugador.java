package net.xaviersala.barcos;

/**
 * Representa el jugador de guerra de barcos.
 *
 * Per poder funcionar necessita que li passin un tauler
 *
 * @author Xavier
 *
 */
public class Jugador {
    /**
     * Tauler del jugador.
     */
    private Tauler tauler;
    /**
     * nom del jugador.
     */
    private String nom;
    /**
     * Amplada màxima possible a triar.
     */
    private int possibleAmplada;
    /**
     * Altura màxima possible a triar.
     */
    private int possibleAltura;

    /**
     * Construeix un jugador a partir del seu nom.
     *
     * @param nomJugador Nom del jugador
     */
    public Jugador(final String nomJugador) {
        this.nom = nomJugador;
        possibleAmplada = 0;
        possibleAltura = 0;
    }

    /**
     * Defineix un tauler al jugador.
     * @param t tauler a posar
     */
    public final void agafaTauler(final Tauler t) {
        tauler = t;
        possibleAmplada = tauler.getAmpladaTauler();
        possibleAltura = tauler.getAlturaTauler();
    }

    /**
     * Retorna la amplada del tauler.
     *
     * @return l'amplada del tauler
     */
    public final int getAmpladaTauler() {
        return possibleAmplada;
    }

    /**
     * Retorna l'altura del tauler.
     *
     * @return l'altura del tauler
     */
    public final int getAlturaTauler() {
        return possibleAltura;
    }

    /**
     * Posa un barco en el tauler (si és pot).
     *
     * @param posicions posicions del barco a posar
     * @return cadena explicant si s'ha posat el barco o no
     */
    public final String posaBarco(final String[] posicions) {
        return tauler.setBarco(posicions);
    }

    /**
     * El jugador tria una casella a l'atzar per intentar endevinar
     * un barco de l'altre jugador.
     *
     * @return la casella triada
     */
    public final String endevinaBarco() {
        // if (tauler == null) { return "Tauler no definit"; }

        String abecedari = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lletra = "";

        int numeroLletra = (int) (Math.random() * possibleAmplada);

        while (numeroLletra > abecedari.length()) {
            lletra += abecedari.charAt(numeroLletra % abecedari.length());
            numeroLletra = (int) (numeroLletra / abecedari.length());
        }
        lletra += abecedari.charAt(numeroLletra);

        int numeroTriat = (int) (Math.random() * possibleAltura);
        return lletra + Integer.toString(numeroTriat);
    }

    /**
     * Comprova en el tauler la casella que li envia l'altre jugador i
     * en retorna els efectes.
     *
     * @param posicio casella a comprovar
     * @return resultat
     */
    public final String comprovaSiHiHaBarcoA(final String posicio) {
        return nom + " : " + tauler.comprovaBarco(posicio);
    }

    /**
     *
     * @return nom del jugador
     */
    public final String getNom() {
        return nom;
    }

    /**
     * @return si aquest jugador ha perdut la partida
     */
    public final boolean haPerdut() {
        return tauler.totsElsBarcosEnfonsats();
    }

}
