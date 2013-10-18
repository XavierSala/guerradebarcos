package net.xaviersala.barcos;

public class Jugador {
    Tauler tauler;
    String nom;
    String possiblesLletres;
    int possibleAmplada; 
    int possibleAltura;
    
    public Jugador(String nom) {
        this.nom = nom;
        possiblesLletres = "";
        possibleAmplada = 0;
        possibleAltura = 0;
    }
    
    public void agafaTauler(Tauler t) {
        tauler = t;
        possibleAmplada = tauler.getAmpladaTauler();
        possibleAltura = tauler.getAlturaTauler();
    }
    
    public String posaBarco(String[] posicions) {
        return tauler.setBarco(posicions);
    }
    
    public String endevinaBarco() {
        // if (tauler == null) { return "Tauler no definit"; }
        
        String abecedari="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lletra = "";
        
        int numeroLletra = (int)(Math.random() * possibleAmplada);
        
        while(numeroLletra>abecedari.length()) {
            lletra += abecedari.charAt(numeroLletra % abecedari.length());
            numeroLletra = (int)(numeroLletra / abecedari.length());            
        }
        lletra += abecedari.charAt(numeroLletra);
        
        int numeroTriat = (int)(Math.random() * possibleAltura);
        return lletra + Integer.toString(numeroTriat);
    }
    
    public String comprovaSiHiHaBarcoA(String posicio) {
        return tauler.comprovaBarco(posicio);
    }

    public String getNom() {        
        return nom;
    }
    
    public boolean haPerdut() {
        return tauler.totsElsBarcosEnfonsats();
    }
    

}
