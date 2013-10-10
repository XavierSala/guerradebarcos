package net.xaviersala.barcos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBarco {

    Barco b, c;
    
    @Before
    public void setUp() throws Exception {
        
        String[] barca1 = { "A1", "A2" };
        String[] barca2 = { "B0", "B1", "B2" };
        
        b = new Barco(barca1);
        c = new Barco(barca2);
    }

    @Test
    public void testBarcoTocat() {
        
          assertTrue("No ha tocat el barco i l'hauria d'haver tocat",b.comprovaPosicio("A1"));
          assertFalse("No ha tocat el barco i l'hauria d'haver tocat",b.comprovaPosicio("A0"));
       
    }

    @Test
    public void test2() {
        fail("Not yet implemented");
    }
    
}
