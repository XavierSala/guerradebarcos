package net.xaviersala.barcos;

import java.util.ArrayList;

/**
 * Representa el tauler de la guerra de barcos i està
 * format per una sèrie de barcos.
 *
 * @author Xavier
 *
 */
public class Tauler {

    /**
     * Número de barcos per defecte.
     */
    private static final int BARCOSDEFECTE = 3;

    /**
     * Caselles d'amplada del tauler.
     */
    private int casellesAmplada;

    /**
     * Retorna l'amplada del tauler.
     *
     * @return Amplada del tauler
     */
    public final int getAmpladaTauler() {
        return casellesAmplada;
    }


    /**
     * Defineix l'amplada del tauler.
     *
     * @param amplada the casellesAmplada to set
     */
    public final void setAmpladaTauler(final int amplada) {
        casellesAmplada = amplada;
    }


    /**
     * Diu l'altura del tauler en caselles.
     * @return the casellesAltura
     */
    public final int getAlturaTauler() {
        return casellesAltura;
    }


    /**
     * Defineix l'altura del tauler en caselles.
     * @param altura the casellesAltura to set
     */
    public final void setAlturaTauler(final int altura) {
        casellesAltura = altura;
    }

    /**
     * Caselles de llargada del tauler.
     */
    private int casellesAltura;

    /**
     * Número de barcos màxim que pot tenir el
     * tauler.
     *
     * Per defecte en té 3
     */
    private int maximNumeroDeBarcos;
    /**
     * Array amb els barcos que té el tauler.
     */
    private ArrayList<Barco> barcos;

    /**
     * Crea un tauler a partir de dos paràmetres que en
     * determinaran l'amplada i l'altura expressada en
     * número de caselles.
     *
     * @param ampladaDesitjada amplada del tauler
     * @param alturaDesitjada altura del tauler
     */
    public Tauler(final int ampladaDesitjada, final int alturaDesitjada) {
        casellesAmplada = ampladaDesitjada;
        casellesAltura = alturaDesitjada;
        maximNumeroDeBarcos = BARCOSDEFECTE;
        barcos = new ArrayList<Barco>();
    }

    /**
     * Defineix el número de barcos que tindrà aquest tauler.
     *
     * @param x número de barcos
     */
    public final void setMaximNumeroBarcos(final int x) {
        maximNumeroDeBarcos = x;
    }

    /**
     * Obtenir el número màxim de barcos que pot tenir el tauler.
     * @return Retorna el número e barcos que pot tenir el tauler
     */
    public final int getMaximNumeroBarcos() {
        return maximNumeroDeBarcos;
    }

    /**
     * Afegeix un barco en les posicions rebudes a l'array
     * barcos.
     *
     * @param casellesDelBarco Les posicions on volem posar el barco
     * @return retorna si el barco s'ha pogut posar o no
     */
    public final String setBarco(final String[] casellesDelBarco) {

        if (barcos.size() < maximNumeroDeBarcos) {

            // Creem un barco per fer-hi comprovacions
            Barco barcoNou = new Barco(casellesDelBarco);

            // 1. Comprovar que hi ha caselles (si no n'hi ha o n'hi
            //    ha alguna d'errònia és un error)
            if (barcoNou.getNumeroDeCaselles() == 0) {
                return "Això no és un barco";
            }

            // 1. Comprovar que les posicions de les caselles són correctes
            if (!posicionsCorrectes(casellesDelBarco)) {
                return "Casella incorrecta";
            }

            // 2. Comprovar que la casella està dins del tauler
            if (barcoNou.getMaximaColumna() >= casellesAmplada
                    || barcoNou.getMaximaFila() >= casellesAltura) {
                return "Casella fora del tauler";
            }

            // 3. Comprovar que el barco és correcte (horitzontal o vertical)
            if (!barcoNou.elBarcoEsCorrecte()) {
                return "El barco no és correcte";
            }

            // 4.Comprovar que no col·lisiona amb cap altre barco
            for (Barco barco : barcos) {
                if (barco.colisionaAmb(barcoNou)) {
                    return "El barco xoca amb els altres";
                }
            }

            barcos.add(barcoNou);

            return "OK";
        }

        return "Ja hi ha tots els barcos";
    }

    /**
     * Comprova si les posicions que es passen del barco són
     * correctes o no.
     * @param casellesDelBarco Caselles a comprovar
     * @return Retorna si són correctes o no
     */
    private boolean posicionsCorrectes(final String[] casellesDelBarco) {
        // -- Provar totes les posicions
        for (String casella: casellesDelBarco) {

            if (!casella.matches("[A-Z]+[0-9]+")) {
                return false;
            }
        }
        return true;
    }


    /**
     * Comprova si la posició que ens han posat la té algun barco
     * o no la té ningú.
     *
     * També haurà de comprovar si algun barco ha estat eliminat
     *
     * @param casellaAComprovar La casella que es vol comprovar
     * @return Retorna el que ha passat "aigua", "tocat", "error", "enfonsat"
     */
    public final String comprovaBarco(final String casellaAComprovar) {

        for (int i = 0; i < barcos.size(); i++) {

            if (barcos.get(i).eliminaCasella(casellaAComprovar)) {
                if (barcos.get(i).estaEnfonsat()) {
                    barcos.remove(i);
                    if (totsElsBarcosEnfonsats()) {
                        return "enfonsat i derrotat";
                    } else {
                        return "enfonsat";
                    }
                } else {
                    return "tocat";
                }
            }
        }

        return "aigua";
    }

    /**
     * Determina si el tauler ha quedat sense barcos i per tant
     * ja no li cal continuar amb la partida.
     *
     * @return Torna si tots els barcos del tauler han estat enfonsats
     */
    public final boolean totsElsBarcosEnfonsats() {
        return barcos.isEmpty();
    }

    /**
     * Genera una cadena amb la mida del tauler.
     *
     * @return retorna la mida del tauler
     */
    public final String getMida() {
        return casellesAmplada + "x" + casellesAltura;
    }

}
