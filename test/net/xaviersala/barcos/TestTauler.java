package net.xaviersala.barcos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTauler {

    Tauler t;
    
    @Before
    public void setUp() throws Exception {
        t = new Tauler(3,3);
        
    }

            
    @Test
    public void testQueNoEntrenMesBarcosDelsPossibles() {
        
        String[] barco1 = { "A2" };
        String[] barco2 = { "A1" };
        
        t.setMaximNumeroBarcos(1);
        assertEquals("El barco hi ha de caber","OK", t.setBarco(barco1));
        assertEquals("El barco no hi ha de caber","Ja hi ha tots els barcos", t.setBarco(barco2));
        
        
    }
    
    @Test
    public void testQueElBarcoEstaDinsDelTauler() {
        
        String[] barco1 = { "A2" };
        String[] barco2 = { "A1" };
        String[] barco3 = { "A3" };
        String[] barco4 = { "B1" };
        String[] barco5 = { "D1" };
        t.setMaximNumeroBarcos(10);
        assertEquals("El barco ha d'entrar","OK", t.setBarco(barco1));
        assertEquals("El barco ha d'entrar","OK", t.setBarco(barco2));
        assertEquals("El barco no ha d'entrar","Casella fora del tauler",t.setBarco(barco3));
        assertEquals("El barco ha d'entrar","OK", t.setBarco(barco4));
        assertEquals("El barco no ha d'entrar","Casella fora del tauler", t.setBarco(barco5));
                
    }
    
    @Test
    public void testPosicionsCorrectes() {
        // Posició correcta (tauler 3x3
        String[] barco1 = {"B2" };
        assertEquals("OK", t.setBarco(barco1));
        
        // Fora del tauler
        barco1[0] = "ABCD23";
        assertEquals("Casella fora del tauler", t.setBarco(barco1));
        
        // Posició incorrecta
        barco1[0] = "A1B2";
        assertEquals("Això no és un barco", t.setBarco(barco1));
        
        // Posició incorrecta
        barco1[0] = "1B";
        assertEquals("Això no és un barco", t.setBarco(barco1));
        
    }
    
  
    
}
