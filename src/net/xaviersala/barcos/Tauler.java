package net.xaviersala.barcos;

import java.util.ArrayList;

public class Tauler {

    /**
     * Caselles d'amplada del tauler
     */
    int casellesAmplada;
    /**
     * Caselles de llargada del tauler
     */
    int casellesAltura;
    
    /**
     * Número de barcos màxim que pot tenir el
     * tauler.
     * 
     * Per defecte en té 3
     */
    int maximNumeroDeBarcos;
    /**
     * Array amb els barcos que té el tauler
     */
    ArrayList<Barco> barcos;
   
    
    /**
     * Crea un tauler a partir de dos paràmetres que en 
     * determinaran l'amplada i l'altura expressada en 
     * número de caselles
     * 
     * @param ampladaDesitjada amplada del tauler
     * @param alturaDesitjada altura del tauler
     */
    public Tauler(int ampladaDesitjada, int alturaDesitjada) {
        casellesAmplada = ampladaDesitjada;
        casellesAltura = alturaDesitjada;    
        maximNumeroDeBarcos = 3;
        barcos = new ArrayList<Barco>();
    }
    
    
    /**
     * Defineix el número de barcos que tindrà aquest tauler.
     * 
     * @param x número de barcos
     */
    public void setMaximNumeroBarcos(int x) {
        maximNumeroDeBarcos = x;
    }
    
    /**
     * Obtenir el número màxim de barcos del taular
     */
    public int getMaximNumeroBarcos() {
        return maximNumeroDeBarcos;
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
    int[] SepararPosicions(String posicioCasella) {
        String abecedari="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int lletresAbecedari = abecedari.length();
        
        int[] resultat = new int[2];
        // Obtenir les lletres
        String partAmbLesLletres = posicioCasella.split("[0-9]+")[0];
        
        int multiplicador = 1;
        int totalLletresPosicio = partAmbLesLletres.length() - 1;
        for (int i=0; i <= totalLletresPosicio; i++) {
            int posicioLletraEnAbecedari = abecedari.indexOf(partAmbLesLletres.charAt(totalLletresPosicio-i)) + 1;
            resultat[0] = resultat[0] + posicioLletraEnAbecedari * multiplicador;
            multiplicador = multiplicador * lletresAbecedari;
        }
        resultat[0] = resultat[0] - 1;
        // Obtenir el número
        resultat[1] =  Integer.parseInt(posicioCasella.split("[A-Z]+")[1]);
                   
        return resultat;
        
    }
    
    /** 
     * Afegeix un barco en les posicions rebudes a l'array
     * barcos.
     * 
     * @param casellesDelBarco Les posicions on volem posar el barco
     * @return retorna si el barco s'ha pogut posar o no
     */
    public boolean setBarco(String[] casellesDelBarco) {

        if (barcos.size() < maximNumeroDeBarcos) {
            
            // -- Provar totes les posicions
            for(String casella: casellesDelBarco) {
                // 1. Comprovar que la posició és correcta
                if (!casella.matches("[A-Z]+[0-9]+")) {
                    return false;
                }
                // 2. Comprovar que el barco està dins del tauler
                int[] posicioBarco = SepararPosicions(casella);                
                if (posicioBarco[0] >= casellesAltura || posicioBarco[1] >= casellesAmplada ) {
                    return false;
                }
                
                // 
                
                // comprovar
            }
            
            
            barcos.add(new Barco(casellesDelBarco));
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
     * @param casellaAComprovar
     * @return Retorna el que ha passat "aigua", "tocat", "error", "enfonsat"
     */
    public String comprovaPosicio(String casellaAComprovar) {
        
        return "error";
    }
    
    /**
     * Determina si el tauler ha quedat sense barcos i per tant
     * ja no li cal continuar amb la partida.
     * 
     * @return
     */
    public boolean totsElsBarcosEnfonsats() {
        return false;
    }
    
    /** 
     * Genera una cadena amb la mida del tauler.
     * 
     * @return retorna la mida del tauler
     */
    public String getMida() {
        return casellesAmplada + "x" + casellesAltura;
    }
    
}
