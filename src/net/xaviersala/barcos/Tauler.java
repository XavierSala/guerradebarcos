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
     * Afegeix un barco en les posicions rebudes a l'array
     * barcos.
     * 
     * @param casellesDelBarco Les posicions on volem posar el barco
     * @return retorna si el barco s'ha pogut posar o no
     */
    public String setBarco(String[] casellesDelBarco) {

        if (barcos.size() < maximNumeroDeBarcos) {
         
            // 1. Comprovar que les posicions de les caselles són correctes
            if (posicionsCorrectes(casellesDelBarco) == false) {
                return "Casella incorrecta";
            }
            
            // Creem un barco per fer-hi comprovacions
            Barco barcoNou = new Barco(casellesDelBarco);
            
            // 2. Comprovar que la casella està dins del tauler
                        
            if (barcoNou.getMaximaColumna() >= casellesAmplada 
                    || barcoNou.getMaximaFila() >= casellesAltura ) {
                return "Casella fora del tauler";
            }
                
            // 3. Comprovar que no es sobreposa amb cap altre barco                
                
            
            
            // Carreguem el barco només si és correcte
            
            if (barcoNou.elBarcoEsCorrecte()) {
                barcos.add(barcoNou);
            }
            return "OK";
        }
        
        return "Ja hi ha tots els barcos";
    }
    
    private boolean posicionsCorrectes(String[] casellesDelBarco) {
        // -- Provar totes les posicions
        for(String casella: casellesDelBarco) {
            
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
