package net.xaviersala.barcos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CasellaTest {

    Casella c; 
    
    @Before
    public void setUp() throws Exception {
        c = new Casella("A1");
    }

    @Test
    public void testConstructor() throws Exception {
        assertEquals("El valor no coincideix", "A1", c.getPosicioString());
        assertEquals("La lletra no està bé", 0, c.getPosicioX());
        assertEquals("El número no coincideix", 1, c.getPosicioY());
        
        c = new Casella("AB23");
        assertEquals("El valor no coincideix", "AB23", c.getPosicioString());
        assertEquals("La lletra no està bé", 27, c.getPosicioX());
        assertEquals("El número no coincideix", 23, c.getPosicioY());
        
        
    }
    
    @Test
    public void testSepararPosicions() {
        assertEquals(3, c.separarPosicions("D3")[0]);
        assertEquals(1, c.separarPosicions("B1")[0]);
        assertEquals(26, c.separarPosicions("AA4")[0]);
        assertEquals(4, c.separarPosicions("AA4")[1]);
        assertEquals(26*26*3 + 26*1 + 5 - 1, c.separarPosicions("CAE123")[0]);
    }
    
    @Test
    public void testEquals() {
        Casella A1 = new Casella("A1");
        Casella A1b = new Casella("A1");
        Casella A2 = new Casella("A2");        
        Casella B1 = new Casella("B1");
        
        String casella = "A1";
        Casella A1c = new Casella(casella);
        
        assertEquals(A1, A1b);
        assertNotEquals(A1, B1);
        assertNotEquals(A1, A2);
        assertEquals("Haurien de ser iguals", A1, A1c);
    }
    
    

}
