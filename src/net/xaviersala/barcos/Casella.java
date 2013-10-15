package net.xaviersala.barcos;

public class Casella {

    String posicioString;
    int[] posicions;
    
    public Casella(String posicioCasella) {
        posicioString = posicioCasella;
        posicions = SepararPosicions(posicioString);
    }
    
    public String getPosicioString() {
        return posicioString;
    }
    
    public int getPosicioX() {
        return posicions[0];
    }
    
    public int getPosicioY() {
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
    
    @Override
    public boolean equals(Object altraCasella){
        // comprovo que no sigui 'null'
        if (altraCasella == null) return false;
        // comprovo que no és el mateix objecte
        if (altraCasella == this) return true;
        // comprovo que sigui realment una casella
        if (!(altraCasella instanceof Casella))return false;
        Casella casella = (Casella)altraCasella;
        
        if (posicioString == casella.getPosicioString()) {
            return true;
        }
        return false;
    }
    
}
