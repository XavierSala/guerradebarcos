package net.xaviersala.barcos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Comprova l'objecte casella.
 * @author Xavier
 *
 */
public class CasellaTest {

    /**
     * Objecte per fer les proves.
     */
    private Casella c;

    /**
     * Inicialitzo un objecte per fer totes les proves.
     * @throws Exception Comprova si ha fallat la construcció
     */
    @Before
    public final void setUp() throws Exception {
        c = new Casella("A1");
    }

    /**
     * Comprovem si el constructor de la casella està funcionant correctament.
     * @throws Exception Falla si l'objecte no s'havia creat
     */
    @Test
    public final void testConstructor() throws Exception {
        assertEquals("El valor no coincideix", "A1", c.getPosicioString());
        assertEquals("La lletra no està bé", 0, c.getPosicioX());
        assertEquals("El número no coincideix", 1, c.getPosicioY());

        c = new Casella("AB23");
        assertEquals("El valor no coincideix", "AB23", c.getPosicioString());
        assertEquals("La lletra no està bé", 27, c.getPosicioX());
        assertEquals("El número no coincideix", 23, c.getPosicioY());

    }

    /**
     * Comprova si la funció que separa les posicions d'una cadena rebuda
     * està funcionant correctament o no. A més converteix la lletra en el
     * seu equivalent numèric.
     *
     * Hauria de poder separar cadenes de l'estil "AB23" en "AB" i "23" i
     * posteriorment retornarà 27 (AB) i 23 (23)
     */
    @Test
    public final void testSepararPosicions() {
        assertEquals(3, c.separarPosicions("D3")[0]);
        assertEquals(1, c.separarPosicions("B1")[0]);
        assertEquals(26, c.separarPosicions("AA4")[0]);
        assertEquals(4, c.separarPosicions("AA4")[1]);
        assertEquals(26 * 26 * 3 + 26 * 1 + 5 - 1,
                c.separarPosicions("CAE123")[0]);
    }

    /**
     * Comprovem que la funció equals() funciona.
     */
    @Test
    public final void testEquals() {
        Casella a1 = new Casella("A1");
        Casella a1b = new Casella("A1");
        Casella a2 = new Casella("A2");
        Casella b1 = new Casella("B1");

        String casella = "A1";
        Casella a1c = new Casella(casella);

        assertEquals(a1, a1b);
        assertNotEquals(a1, b1);
        assertNotEquals(a1, a2);
        assertEquals("Haurien de ser iguals", a1, a1c);
    }

}
