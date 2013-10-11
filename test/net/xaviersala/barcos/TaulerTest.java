package net.xaviersala.barcos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaulerTest {

    Tauler t;
    
    @Before
    public void setUp() throws Exception {
        t = new Tauler(3,3);
        
    }

            
    @Test
    public void testQueNoEntrenMesBarcosDelsPossibles() {
        
        String[] barco1 = { "A2" };
        String[] barco2 = { "A1" };
        
        t.setNumeroBarcos(1);
        assertTrue("El barco hi ha de caber",t.setBarco(barco1));
        assertTrue("El barco no hi ha de caber",!t.setBarco(barco2));
        
        
    }
    
    @Test
    public void testQueElBarcoEstaDinsDelTauler() {
        
        String[] barco1 = { "A2" };
        String[] barco2 = { "A1" };
        String[] barco3 = { "A3" };
        String[] barco4 = { "B1" };
        String[] barco5 = { "D1" };
        t.setNumeroBarcos(10);
        assertTrue("El barco ha d'entrar",t.setBarco(barco1));
        assertTrue("El barco ha d'entrar",t.setBarco(barco2));
        assertTrue("El barco no ha d'entrar",!t.setBarco(barco3));
        assertTrue("El barco ha d'entrar",t.setBarco(barco4));
        assertFalse("El barco no ha d'entrar",t.setBarco(barco5));
        
        
    }

    @Test
    public void testSepararPosicions() {
        assertEquals(3, t.SepararPosicions("D3")[0]);
        assertEquals(1, t.SepararPosicions("B1")[0]);
        assertEquals(26, t.SepararPosicions("AA4")[0]);
        assertEquals(4, t.SepararPosicions("AA4")[1]);
        assertEquals(26*26*3 + 26*1 + 5 - 1, t.SepararPosicions("CAE123")[0]);
    }
    
    @Test
    public void testPosicionsCorrectes() {
        // Posició correcta (tauler 3x3
        String[] barco1 = {"B2" };
        assertTrue(t.setBarco(barco1));
        
        // Fora del tauler
        barco1[0] = "ABCD23";
        assertFalse(t.setBarco(barco1));
        
        // Posició incorrecta
        barco1[0] = "A1B2";
        assertFalse(t.setBarco(barco1));
        
        // Posició incorrecta
        barco1[0] = "1B";
        assertFalse(t.setBarco(barco1));
        
    }
    
    // -- que els barcos no es sobreposin
    // -- no diagonals o posicions saltades
    
}
