package net.xaviersala.barcos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Comprovació de la classe Barco.
 *
 * @author Xavier
 *
 */
public class BarcoTest {

    /**
     * Llista de barcos.
     */
    private ArrayList<Barco> barcos = new ArrayList<Barco>();

    /**
     * Creació de diversos barcos per fer les proves.
     * @throws Exception Ha fallat la creació dels barcos
     */
    @Before
    public final void setUp() throws Exception {

        // Cadenes per fer els exemples dels barcos
        //       cada línia és un barco diferent...
        String[][] barques = {{"A1", "A2"},
                              {"B0", "B1", "B2"},
                              {},
                              {"A2", "B2", "B3"}, // Barco erròni
                              {"A1", "BA1B", "1"},
                              {"A2", "B2", "C2", "D2"}
                            };

        // Crea un array de barcos per fer les proves
        for (String[] barca : barques) {
            barcos.add(new Barco(barca));
        }

    }


    /**
     * Comprovem si l'objecte creat té el número de caselles adequat.
     * o no.
     *
     * Si el barco té alguna casella errònia el barco ha d'estar en blanc
     */
    @Test
    public final void testCrearBarco() {
        assertEquals("Ha de tenir 2 caselles", 2,
                barcos.get(0).getNumeroDeCaselles());
        assertEquals("Ha de tenir 3 caselles", 3,
                barcos.get(1).getNumeroDeCaselles());
        assertEquals("Ha de tenir 0 caselles", 0,
                barcos.get(2).getNumeroDeCaselles());
        assertEquals("Ha de tenir 3 caselles", 3,
                barcos.get(3).getNumeroDeCaselles());
        assertEquals("Ha de tenir 0 caselles", 0,
                barcos.get(4).getNumeroDeCaselles());
    }

    /**
     * Comprova el funcionament de la casella de tocar els barcos. Especialment
     * comprova si el barco s'enfonsa o no.
     */
    @Test
    public final void testBarcoTocat() {

          assertTrue("No ha tocat el barco i l'hauria d'haver tocat",
                  barcos.get(0).eliminaCasella("A1"));
          assertTrue("No ha tocat el barco i l'hauria d'haver tocat",
                  barcos.get(0).eliminaCasella("A2"));
          assertFalse("No ha tocat el barco i l'hauria d'haver tocat",
                  barcos.get(0).eliminaCasella("A1"));
          assertFalse("No ha tocat el barco i l'hauria d'haver tocat",
                  barcos.get(0).eliminaCasella("A2"));
          assertFalse("No ha tocat el barco i l'hauria d'haver tocat",
                  barcos.get(0).eliminaCasella("A0"));
          assertTrue("No ha tocat el barco i l'hauria d'haver tocat",
                  barcos.get(1).eliminaCasella("B2"));
          assertTrue("No ha tocat el barco i l'hauria d'haver tocat",
                  barcos.get(1).eliminaCasella("B0"));
          assertFalse("No ha tocat el barco i l'hauria d'haver tocat",
                  barcos.get(1).eliminaCasella("B6"));

    }

    /**
     * Comprova que la funció elimina el barco.
     */
    @Test
    public final void testPartsDelBarcoSEnfonsen() {
        assertTrue("Hauria de tocar el barco",
                barcos.get(0).eliminaCasella("A1"));
        assertFalse("No hauria de tocar el barco",
                barcos.get(0).eliminaCasella("A1"));
    }

    /**
     * Comprova si la funció de tocar el barco no continua enfonsant el barco
     * quan ja ho havia estat.
     */
    @Test
    public final void testBarcoEnfonsat() {
        assertFalse("Està enfonsat i no hauria",
                barcos.get(0).estaEnfonsat());
        assertTrue("No està enfonsat",
                barcos.get(2).estaEnfonsat());
    }

    /**
     * Comprovem que la funció ens retorna les posicions d'un tauler on hi ha
     * barco.
     */
    @Test
    public final void testCadenaAmbLesPosicionsDelBarco() {
        assertEquals("La cadena retornada no és correcta",
                "A1 A2", barcos.get(0).toString());
    }

    /**
     * Comprovem si la funció falla si el valor és 'null'.
     */
    @Test
    public final void testEliminarNull() {
        assertFalse("Hauria de tornar false",
                barcos.get(0).eliminaCasella(null));
    }

    /**
     * Comprova si dues posicions són consecutives o no.
     */
    @Test
    public final void testPosicionsConsecutives() {
        assertTrue("El barco és correcte horitzontal",
                barcos.get(0).elBarcoEsCorrecte());
        assertTrue("El barco és correcte vertical",
                barcos.get(1).elBarcoEsCorrecte());
        assertFalse("El barco no és correcte",
                barcos.get(2).elBarcoEsCorrecte());
        assertFalse("El barco no és consecutiu",
                barcos.get(3).elBarcoEsCorrecte());
        assertFalse("El barco no és consecutiu",
                barcos.get(4).elBarcoEsCorrecte());
    }

    /**
     * Comprova si un barco està sobre l'altre.
     */
    @Test
    public final void testColisioBarcos() {
        assertFalse("Barcos no colisionen",
                barcos.get(0).colisionaAmb(barcos.get(1)));
        assertTrue("Barcos colisionen",
                barcos.get(0).colisionaAmb(barcos.get(5)));
        assertTrue("Barcos no colisionen",
                barcos.get(1).colisionaAmb(barcos.get(5)));
    }

}
