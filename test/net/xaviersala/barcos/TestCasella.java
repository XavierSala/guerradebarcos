package net.xaviersala.barcos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCasella {

    Casella c; 
    
    @Before
    public void setUp() throws Exception {
        c = new Casella("A1");
    }

    @Test
    public void testSepararPosicions() {
        assertEquals(3, c.SepararPosicions("D3")[0]);
        assertEquals(1, c.SepararPosicions("B1")[0]);
        assertEquals(26, c.SepararPosicions("AA4")[0]);
        assertEquals(4, c.SepararPosicions("AA4")[1]);
        assertEquals(26*26*3 + 26*1 + 5 - 1, c.SepararPosicions("CAE123")[0]);
    }
    
    @Test
    public void testEquals() {
        Casella A1 = new Casella("A1");
        Casella A1b = new Casella("A1");
        Casella A2 = new Casella("A2");        
        Casella B1 = new Casella("B1");
        
        assertEquals(A1, A1b);
        assertNotEquals(A1, B1);
        assertNotEquals(A1, A2);
    }

}
