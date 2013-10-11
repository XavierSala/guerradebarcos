package net.xaviersala.barcos;

import java.util.ArrayList;

public class Tauler {

    /**
     * Caselles d'amplada del tauler
     */
    int ampladaTauler;
    /**
     * Caselles de llargada del tauler
     */
    int alturaTauler;
    
    /**
     * Número de barcos màxim que pot tenir el
     * tauler.
     * 
     * Per defecte en té 3
     */
    int numeroBarcos;
    /**
     * Array amb els barcos que té el tauler
     */
    ArrayList<Barco> barcos;
   
    
    /**
     * Crea un tauler a partir de dos paràmetres que en 
     * determinaran l'amplada i l'altura expressada en 
     * número de caselles
     * 
     * @param amplada amplada del tauler
     * @param altura altura del tauler
     */
    public Tauler(int amplada, int altura) {
        ampladaTauler = amplada;
        alturaTauler = altura;    
        numeroBarcos = 3;
        barcos = new ArrayList<Barco>();
    }
    
    
    /**
     * Defineix el número de barcos que tindrà aquest tauler.
     * 
     * @param x número de barcos
     */
    public void setNumeroBarcos(int x) {
        numeroBarcos = x;
    }
    
    /**
     * Funció que separa el que ens ha enviat un usuari i ens retorna
     * la posició triada en un array de integers.
     * 
     * Per exemple AB23 ha de tornar [27,23]
     * 
     * @param posicioUsuari Posició triada en la forma "AA23"
     * @return retorna un array amb les posicions numèriques del
     *         barco
     */
    int[] SepararPosicions(String posicioUsuari) {
        String abecedari="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int totalLletres = abecedari.length();
        
        int[] resultat = new int[2];
        // Obtenir les lletres
        String lletres = posicioUsuari.split("[0-9]+")[0];
        
        int exponent = 1;
        int numLletres = lletres.length() - 1;
        for (int i=0; i <= numLletres; i++) {
            int indexLletra = abecedari.indexOf(lletres.charAt(numLletres-i)) + 1;
            resultat[0] = resultat[0] + indexLletra * exponent;
            exponent = exponent * totalLletres;
        }
        resultat[0] = resultat[0] - 1;
        // Obtenir el número
        resultat[1] =  Integer.parseInt(posicioUsuari.split("[A-Z]+")[1]);
                   
        return resultat;
        
    }
    
    /** 
     * Afegeix un barco en les posicions rebudes a l'array
     * barcos.
     * 
     * @param posicions Les posicions on volem posar el barco
     * @return retorna si el barco s'ha pogut posar o no
     */
    public boolean setBarco(String[] posicions) {

        if (barcos.size() < numeroBarcos) {
            
            // -- Provar totes les posicions
            for(String posicio: posicions) {
                // 1. Comprovar que la posició és correcta
                if (!posicio.matches("[A-Z]+[0-9]+")) {
                    return false;
                }
                // 2. Comprovar que el barco està dins del tauler
                int[] pesaBarco = SepararPosicions(posicio);                
                if (pesaBarco[0] >= alturaTauler || pesaBarco[1] >= ampladaTauler ) {
                    return false;
                }
                
                // 
                
                // comprovar
            }
            
            
            barcos.add(new Barco(posicions));
            return true;
        }
        
        return false;
    }
    
    /**
     * Comprova si la posició que ens han posat la té algun barco
     * o no la té ningú.
     * 
     * També haurà de comprovar si algun barco ha estat eliminat
     * 
     * @param casella
     * @return Retorna el que ha passat "aigua", "tocat", "error", "enfonsat"
     */
    public String comprovaPosicio(String casella) {
        
        return "error";
    }
    
    /**
     * Determina si el tauler ha quedat sense barcos i per tant
     * ja no li cal continuar amb la partida.
     * 
     * @return
     */
    public boolean estaSenseBarcos() {
        return false;
    }
    
    /** 
     * Genera una cadena amb la mida del tauler.
     * 
     * @return retorna la mida del tauler
     */
    public String getMida() {
        return ampladaTauler + "x" + alturaTauler;
    }
    
}
