package net.xaviersala.barcos;

/**
 * Representa una casella del tauler de Guerra de Barcos.
 *
 * Cada casella sap en quina posició del tauler està i prou
 *
 * @author Xavier
 *
 */
public class Casella {

    /**
     * Posició de la casella amb caràcters.
     * per exemple "A2"
     */
    private String posicioString;
    /**
     * Posició de la casella en coordenades cartesianes.
     * per exemple [0, 2]
     */
    private int[] posicions;

    /**
     * Construeix una casella a partir de la coordenada especificada
     * en la cadena "F2".
     *
     * @param posicioCasella Coordenada especificada
     */
    public Casella(final String posicioCasella) {
        posicioString = posicioCasella;
        posicions = separarPosicions(posicioString);
    }

    /**
     * Retorna la coordenada de la casella.
     *
     * @return la coordenada de la casella
     */
    public final String getPosicioString() {
        return posicioString;
    }

    /**
     *
     * @return la posició X de la casella
     */
    public final int getPosicioX() {
        return posicions[0];
    }

    /**
     *
     * @return la posició Y de la casella.
     */
    public final int getPosicioY() {
        return posicions[1];
    }

    /**
     * Funció que separa el que ens ha enviat un usuari i ens retorna
     * la posició triada en un array de integers.
     *
     * Per exemple AB23 ha de tornar [27,23]
     *
     * @param posicioCasella Posició triada en la forma "AA23"
     * @return retorna un array amb les posicions numèriques del
     *         barco
     */
    final int[] separarPosicions(final String posicioCasella) {
        String abecedari = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int lletresAbecedari = abecedari.length();

        int[] resultat = new int[2];
        // Obtenir les lletres
        String partAmbLesLletres = posicioCasella.split("[0-9]+")[0];

        int multiplicador = 1;
        int totalLletres = partAmbLesLletres.length() - 1;
        for (int i = 0; i <= totalLletres; i++) {
            char caracterAvaluar = partAmbLesLletres.charAt(totalLletres - i);
            int posicioEnAbecedari = abecedari.indexOf(caracterAvaluar) + 1;
            resultat[0] = resultat[0]
                    + posicioEnAbecedari * multiplicador;
            multiplicador = multiplicador * lletresAbecedari;
        }
        resultat[0] = resultat[0] - 1;
        // Obtenir el número
        resultat[1] =  Integer.parseInt(posicioCasella.split("[A-Z]+")[1]);

        return resultat;

    }


    /**
     * Dóna un identificador únic per la classe segons la especificació
     * de Java
     *
     * Torno el mateix però no ho hauria de fer.
     *
     * @return codi
     *
     */
    @Override
    public final int hashCode() {
        int result = 0;
        result = 1;
        return result;
      }

    /**
     * Comprova si dues caselles són iguals això ho fa només
     * comparant els Strings.
     *
     * @param altraCasella casella que es vol comprovar si és igual
     * @return La casella és igual que aquesta
     */
    @Override
    public final boolean equals(final Object altraCasella) {
        // comprovo que no sigui 'null'
        if (altraCasella == null) {
            return false;
        }
        // comprovo que no és el mateix objecte
        if (altraCasella == this) {
            return true;
        }
        // comprovo que sigui realment una casella
        if (!(altraCasella instanceof Casella)) {
            return false;
        }
        Casella casella = (Casella) altraCasella;

        if (posicioString.equals(casella.getPosicioString())) {
            return true;
        }
        return false;
    }

}
