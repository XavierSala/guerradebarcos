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

    // -- barco dins del tauler
    // -- que els barcos no es sobreposin
    // -- no diagonals o posicions saltades
        
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

}
