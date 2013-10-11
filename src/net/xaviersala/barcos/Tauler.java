package net.xaviersala.barcos;

import java.util.ArrayList;

public class Tauler {

    int ampladaTauler;
    int alturaTauler;
    int numeroBarcos;
    ArrayList<Barco> barcos;
   
    
    public Tauler(int amplada, int altura) {
        ampladaTauler = amplada;
        alturaTauler = altura;    
        numeroBarcos = 3;
        barcos = new ArrayList<Barco>();
    }
    
    
    public void setNumeroBarcos(int x) {
        numeroBarcos = x;
    }
    
 
    private int SepararPosicions(String posicio, int inici) {
        String abecedari = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int resultat=0;
                
        int i=0;
        while(abecedari.indexOf(posicio.charAt(i))!=-1) {            
            i++;
        }
        
        
        if (inici==1) {
            
        }
        else
        {
            
            resultat = Integer.parseInt(posicio.substring(i));
        }
        return resultat;
    }
    
    /** 
     * Afegeix un barco en les posicions rebudes a l'array
     * barcos.
     * 
     * @param posicions
     * @return
     */
    public boolean setBarco(String[] posicions) {

        if (barcos.size() < numeroBarcos) {
            
            // -- Trobar les posicions
            for(String posicio: posicions) {
                // Separar-les
                int altura = SepararPosicions(posicio, 1);
                int amplada = SepararPosicions(posicio, 2);
                // comprovar
            }
            
            
            barcos.add(new Barco(posicions));
            return true;
        }
        
        return false;
    }
    
    public String comprovaPosicio(String casella) {
        
        return "error";
    }
    
    public boolean estaSenseBarcos() {
        return false;
    }
    
    public String getMida() {
        return ampladaTauler + "x" + alturaTauler;
    }
    
}
