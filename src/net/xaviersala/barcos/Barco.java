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
    ArrayList<String> posicions;
    
    /**
     * Constructor de barcos a partir d'una llista de posicions.
     * 
     * @param posicions Rep les posicions del barco com a paràmetres
     */
    public Barco(String[] posicions) {
        this.posicions = new ArrayList<String>();
        for(String posicio: posicions) {
            this.posicions.add(posicio);
        }
    }

    /**
     * Funció que comprova si han tocat el barco a partir d'una posició
     * que li especifiquem.
     * 
     * Les posicions estaran en format text "A1", "E6", etc..
     * 
     * En cas de que la posició hi sigui s'elimina del barco perquè 
     * aquesta posició ha estat "enfonsada"
     * 
     * @param lloc La posició a comprovar
     * @return Retorna si el barco ha estat tocat o no
     */
    public boolean comprovaPosicio(String lloc) {
        
        int pesa = posicions.indexOf(lloc);
        
        if (pesa != -1) return true;
        return false;
    }
    
}
