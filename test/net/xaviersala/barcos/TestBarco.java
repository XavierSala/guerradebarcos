package net.xaviersala.barcos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBarco {

    Barco b, c, d;
    
    @Before
    public void setUp() throws Exception {
        
        String[] barca1 = { "A1", "A2" };
        String[] barca2 = { "B0", "B1", "B2" };
        String[] barca3 = {};
        
        // Crea els barcos que faran servir els exemples
        b = new Barco(barca1);
        c = new Barco(barca2);
        d = new Barco(barca3);
    }

    @Test
    public void testBarcoTocat() {
        
          assertTrue("No ha tocat el barco i l'hauria d'haver tocat",b.comprovaPosicio("A1"));
          assertFalse("No ha tocat el barco i l'hauria d'haver tocat",b.comprovaPosicio("A0"));
       
    }

    @Test
    public void testPartsDelBarcoSEnfonsen() {
        assertTrue("Hauria de tocar el barco", b.comprovaPosicio("A1"));
        assertFalse("No hauria de tocar el barco", b.comprovaPosicio("A1"));
    }
    
    @Test
    public void testBarcoEnfonsat() {
        assertFalse("Està enfonsat i no hauria",b.estaEnfonsat());               
        assertTrue("No està enfonsat",d.estaEnfonsat());
    }
    
    @Test
    public void testPosicionsBarco() {
        assertEquals("A1 A2", b.toString());
    }
    
    @Test
    public void testPosicionsNull() {
        assertFalse("Hauria de tornar false", b.comprovaPosicio(null));        
    }
    
}
