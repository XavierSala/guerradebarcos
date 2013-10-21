package net.xaviersala.barcos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JugadorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGenerarPosicions() {
        Jugador j = new Jugador("prova");
        j.possibleAltura = 5;
        j.possibleAmplada = 5;
        
        
        for(int i=0; i<10; i++) {
            String resultat = j.endevinaBarco();
            assertTrue(resultat.matches("[A-Z]+[0-9]+"));
        }
        
    }

}
