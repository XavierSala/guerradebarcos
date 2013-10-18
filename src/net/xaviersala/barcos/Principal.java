package net.xaviersala.barcos;

import java.util.ArrayList;

public class Principal {
    
    
    
    public final static int JUGADORS  = 2;
    public final static int NUMERODEBARCOS = 2;
    
    public final static int AMPLADATAULER = 5;
    public final static int ALTURATAULER = 5;
    
    public final static String[] nomsJugadors = { "Pere", "Pau" };

    public static void posarBarcos(Jugador jugador) {
        
        String[][] possiblesBarcos = { { "A1", "A2" }, {"B1", "B2", "B3" }, {"A3", "B3","C3"}, {"E1","E2"}, {"A4","B4","C4" },
                {"C3","D3","E3" }};
    
        System.out.println("-----------------------------");
        for(int i=0; i<NUMERODEBARCOS; i++) {
            String[] candidat;
            do {
                candidat = possiblesBarcos[(int)(Math.random()*possiblesBarcos.length)];
                System.out.println("... jugador " + jugador.getNom() + " prova ... " );
            } while(jugador.posaBarco(candidat) != "OK");
            
            System.out.print("........... jugador " + jugador.getNom() + " posa  barco a ");
            for(String s: candidat) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
        
        
        
        for(int i=0; i<JUGADORS; i++) {
            jugadors.add(new Jugador(nomsJugadors[i]));
            jugadors.get(jugadors.size()-1).agafaTauler(new Tauler(AMPLADATAULER,ALTURATAULER)); 
            posarBarcos(jugadors.get(i));          
        }
        
        
        System.out.println("-------------------------------------");
        System.out.println("           COMENÇA EL JOC            ");
        System.out.println("-------------------------------------");
        int jugadorQueEscull = 0;
        int jugadorQueEspera = 1;
        
        while(jugadors.get(0).haPerdut() == false && jugadors.get(1).haPerdut() == false) {
            
            String tria = jugadors.get(jugadorQueEscull).endevinaBarco();
            String resultat = jugadors.get(jugadorQueEspera).comprovaSiHiHaBarcoA(tria);
            System.out.println(jugadors.get(jugadorQueEscull).getNom() + ": " + tria + " --> " + resultat);
            
            if (resultat.equals("aigua")) {
                jugadorQueEspera = jugadorQueEscull;
                jugadorQueEscull = (jugadorQueEscull + 1) % JUGADORS;
            }
            // 
        }
        
        
        

    }

}
