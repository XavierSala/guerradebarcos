package net.xaviersala.barcos;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestBarco {

    ArrayList<Barco> barcos = new ArrayList<Barco>();
    
    @Before
    public void setUp() throws Exception {
        
        // Cadenes per fer els exemples dels barcos
        //       cada línia és un barco diferent...
        String[][] barques = { { "A1", "A2" },
                              { "B0", "B1", "B2" },
                              {},
                              { "A2", "B2", "B3" }, // Barco erròni 
                              { "A1", "BA1B", "1" }
                            };
        
        // Crea un array de barcos per fer les proves       
        for(String[] barca : barques) {
            barcos.add(new Barco(barca));
        }

        
    }
    
    
    /*
     * Comprovem si l'objecte creat té el número de caselles adequat
     * o no.
     * 
     * Si el barco té alguna casella errònia el barco ha d'estar en blanc
     */
    @Test
    public void testCrearBarco() {
        assertEquals("Ha de tenir 2 caselles", 2, barcos.get(0).getNumeroDeCaselles());
        assertEquals("Ha de tenir 3 caselles", 3, barcos.get(1).getNumeroDeCaselles());
        assertEquals("Ha de tenir 0 caselles", 0, barcos.get(2).getNumeroDeCaselles());
        assertEquals("Ha de tenir 3 caselles", 3, barcos.get(3).getNumeroDeCaselles());
        assertEquals("Ha de tenir 0 caselles", 0, barcos.get(4).getNumeroDeCaselles());        
    }

    @Test
    public void testBarcoTocat() {
        
          assertTrue("No ha tocat el barco i l'hauria d'haver tocat",barcos.get(0).eliminaCasella("A1"));
          assertFalse("No ha tocat el barco i l'hauria d'haver tocat",barcos.get(0).eliminaCasella("A0"));
       
    }

    @Test
    public void testPartsDelBarcoSEnfonsen() {
        assertTrue("Hauria de tocar el barco", barcos.get(0).eliminaCasella("A1"));
        assertFalse("No hauria de tocar el barco", barcos.get(0).eliminaCasella("A1"));
    }
    
    @Test
    public void testBarcoEnfonsat() {
        assertFalse("Està enfonsat i no hauria",barcos.get(0).estaEnfonsat());               
        assertTrue("No està enfonsat",barcos.get(2).estaEnfonsat());
    }
    
    @Test
    public void testCadenaAmbLesPosicionsDelBarco() {
        assertEquals("La cadena retornada no és correcta", "A1 A2", barcos.get(0).toString());
    }
    
    @Test
    public void testEliminarNull() {
        assertFalse("Hauria de tornar false", barcos.get(0).eliminaCasella(null));        
    }
    
    
    @Test
    public void testPosicionsConsecutives() {
        assertTrue("El barco és correcte horitzontal", barcos.get(0).elBarcoEsCorrecte());
        assertTrue("El barco és correcte vertical", barcos.get(1).elBarcoEsCorrecte());
        assertFalse("El barco no és correcte", barcos.get(2).elBarcoEsCorrecte());
        assertFalse("El barco no és consecutiu", barcos.get(3).elBarcoEsCorrecte());
        assertFalse("El barco no és consecutiu", barcos.get(4).elBarcoEsCorrecte());
    }
    
}
