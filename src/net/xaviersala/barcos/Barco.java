package net.xaviersala.barcos;

import java.util.ArrayList;

/**
 * La classe Barco representa un barco en el joc de
 * la guerra de barcos.
 *
 * Donat que la seva posició serà dins del tauler es
 * guarda la posició que tindrà cada una de les peces
 * del barco en el tauler.
 *
 * @author Xavier
 *
 */
public class Barco {
    /**
     * Llista de caselles que té el barco.
     */
    private ArrayList<Casella> caselles;

    /**
     * Constructor de barcos a partir d'una llista de posicions.
     *
     * Si una de les caselles és errònia, no afegeix el barco
     *
     * @param casellesPerAfegir Rep les posicions del barco com a paràmetres
     */
    public Barco(final String[] casellesPerAfegir) {
        this.caselles = new ArrayList<Casella>();
        for (String casella: casellesPerAfegir) {
            if (!casella.matches("[A-Z]+[0-9]+")) {
                // Error! No afegir el barco
                caselles.clear();
                break;
            }
            this.caselles.add(new Casella(casella));
        }
    }

    /**
     * Comprova si el barco té les caselles en posicions consecutives en
     * vertical o horitzontal.
     *
     * @return Si és correcte
     */
    final boolean elBarcoEsCorrecte() {
        // Si no hi ha caselles, no és un barco
        // Si no hi ha caselles, no és un barco
        if (caselles.size() == 0) {
            return false;
        }

        // Si només té una casella és un "submarí"!
        if (caselles.size() == 1) {
            return true;
        }

        // Miro les dues primeres posicions per saber
        // si és horitzontal o vertical
        Casella posicio0 = caselles.get(0);
        Casella posicio1 = caselles.get(1);

        // Comprovo si és un barco...
        if (posicio0.getPosicioX() == posicio1.getPosicioX()) {
            return isBarcoHoritzontal();
        } else if (posicio0.getPosicioY() == posicio1.getPosicioY()) {
            return isBarcoVertical();
        }
        return false;
    }

    /**
     * Comprova si el barco és un barco vertical. Els barcos verticals
     * destaquen perquè la coordenada Y és sempre la mateixa.
     *
     * (millorable, està fet d'aquesta forma per claredat)
     *
     * @return Si és vertical o no
     */
    private boolean isBarcoVertical() {
        int posicioFixa = caselles.get(0).getPosicioY();
        int posicioMobil = caselles.get(0).getPosicioX();

        // Podria començar per 2 però no ho faig per fer la funció
        // usable des de diferents llocs
        for (int i = 1; i < caselles.size(); i++) {
            if (caselles.get(i).getPosicioY() != posicioFixa
                    || caselles.get(i).getPosicioX() != posicioMobil + i) {
                return false;
            }
        }
        return true;
    }

    /**
     * Comprova si el barco és un barco horitzontal. Els barcos horitzontals
     * destaquen perquè la coordenada X és sempre la mateixa.
     *
     * (millorable, està fet d'aquesta forma per claredat)
     *
     * @return Si és horitzontals o no
     */
    private boolean isBarcoHoritzontal() {
        int posicioFixa = caselles.get(0).getPosicioX();
        int posicioMobil = caselles.get(0).getPosicioY();

        for (int i = 1; i < caselles.size(); i++) {
            if (caselles.get(i).getPosicioX() != posicioFixa
                    || caselles.get(i).getPosicioY() != posicioMobil + i) {
                return false;
            }
        }
        return true;
    }


    /**
     * Funció que comprova si han tocat el barco a partir d'una posició
     * que li especifiquem.
     *
     * En cas de que la posició hi sigui es tornarà la posició dins de
     * l'array o bé -1 i no l'ha trobat
     *
     * @param casellaAComprovar La posició a comprovar
     * @return Retorna si l'ha trobat o no
     */
    public final int comprovaPosicio(final String casellaAComprovar) {

        if (casellaAComprovar == null) {
            return -1;
        }

        return caselles.indexOf(new Casella(casellaAComprovar));
    }

    /**
     * Esborra la casella especificada.
     *
     * La casella s'especifica en una cadena amb la posició
     *
     * @param casellaAEliminar La posició a comprovar
     * @return Retorna si ha eliminat el barco o no
     */
    public final boolean eliminaCasella(final String casellaAEliminar) {
        if (casellaAEliminar == null) {
            return false;
        }

        int indexCasella = comprovaPosicio(casellaAEliminar);

        if (indexCasella != -1) {
            caselles.remove(indexCasella);
            return true;
        }
        return false;
    }

    /**
     * Determina si el barco ha estat enforsat perquè
     * no li queden caselles.
     *
     * @return Retorna si el barco està enfonsat o no
     */
    public final boolean estaEnfonsat() {
        return (caselles.size() == 0);
    }

    /**
     * Columna més gran usada pel barco.
     *
     * @return la columna més gran
     */
    public final int getMaximaColumna() {
        int maxim = 0;
        for (Casella casella: caselles) {
            if (casella.getPosicioX() > maxim) {
                maxim = casella.getPosicioX();
            }
        }
        return maxim;
    }

    /**
     * Fila més gran usada pel barco.
     *
     * @return la fila més gran
     */
    public final int getMaximaFila() {
        int maxim = caselles.get(0).getPosicioY();
        for (Casella casella: caselles) {
            if (casella.getPosicioY() > maxim) {
                maxim = casella.getPosicioX();
            }
        }
        return maxim;
    }

    /**
     * Retorna el número de caselles del barco.
     *
     * @return número de caselles
     */
    public final int getNumeroDeCaselles() {
        return caselles.size();
    }

    /**
     * Retorna les caselles del barco en un String
     * separat per espais.
     *
     * @return cadena amb les caselles del barco
     */
    @Override
    public final String toString() {
        String resultat = "";
        for (Casella s: caselles) {
            resultat = resultat +  s.getPosicioString() + " ";
        }
        return resultat.trim();
    }

    /**
     * Funció que determina si el barco passat com a paràmetre
     * col·lisiona amb aquest.
     * @param b barco a comprovar
     *
     * @return si col·lisiona o no
     */
    public final boolean colisionaAmb(final Barco b) {
        for (Casella casella: caselles) {
            if (b.comprovaPosicio(casella.getPosicioString()) != -1)  {
                return true;
            }
        }
        return false;
    }

}
