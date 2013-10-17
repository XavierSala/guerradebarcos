package net.xaviersala.barcos;

public class Jugador {
    Tauler tauler;
    String nom;
    
    public Jugador(String nom) {
        this.nom = nom;
    }
    
    public void creaTauler(Tauler t) {
        tauler = t; 
    }
    
    public String posaBarco(String[] posicions) {
        return tauler.setBarco(posicions);
    }
    
    public String endevinaBarco() {
        return "A4";
    }
    
    public String tensBarcoA(String posicio) {
        return tauler.comprovaPosicio(posicio);
    }

}
