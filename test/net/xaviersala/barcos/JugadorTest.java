package net.xaviersala.barcos;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Comprovem la classe Jugador.
 * @author Xavier
 *
 */
public class JugadorTest {

    /**
     * Comprovació del Jugador.
     *
     * @throws Exception falla la creació del jugador
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Comprova la funció generar posicions.
     */
    @Test
    public final void testGenerarPosicions() {
        Jugador j = new Jugador("prova");
        Tauler t = new Tauler(5, 5);
        j.agafaTauler(t);

        for (int i = 0; i < 10; i++) {
            String resultat = j.endevinaBarco();
            assertTrue(resultat.matches("[A-Z]+[0-9]+"));
        }

    }

}
