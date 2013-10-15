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
    ArrayList<Casella> caselles;
    
    /**
     * Constructor de barcos a partir d'una llista de posicions.
     * 
     * @param casellesPerAfegir Rep les posicions del barco com a paràmetres
     */
    public Barco(String[] casellesPerAfegir) {
        this.caselles = new ArrayList<Casella>();
        for(String casella: casellesPerAfegir) {            
            this.caselles.add(new Casella(casella));
        }
    }
    
    boolean elBarcoEsCorrecte() {
        return true;
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
     * @param casellaAComprovar La posició a comprovar
     * @return Retorna si el barco ha estat tocat o no
     */
    public boolean comprovaPosicio(String casellaAComprovar) {
        
        int indexCasella = caselles.indexOf(casellaAComprovar);
        
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
    public boolean estaEnfonsat() {
        return (caselles.size() == 0);
    }
    
    /**
     * Retorna les caselles del barco en un String 
     * separat per espais
     * 
     */
    @Override
    public String toString() {
        String resultat = ""; 
        for(Casella s: caselles) {
            resultat = resultat +  s.getPosicioString() + " ";
        }
        return resultat.trim();
    }
    
}
