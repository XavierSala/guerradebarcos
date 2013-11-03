package net.xaviersala.barcos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Comprovem el funcionament de la classe Tauler.
 *
 * @author Xavier
 *
 */
public class TaulerTest {

    /**
     * Variable amb el constructor.
     */
    private Tauler t;

    /**
     * Crea un objecte per fer les proves.
     * @throws Exception Si falla la creació
     */
    @Before
    public final void setUp() throws Exception {
        t = new Tauler(3, 3);

    }

    /**
     * Comprova que no entren més barcos dels permesos dins del tauler.
     */
    @Test
    public final void testQueNoEntrenMesBarcosDelsPossibles() {

        String[] barco1 = {"A2"};
        String[] barco2 = {"A1"};

        t.setMaximNumeroBarcos(1);
        assertEquals("El barco hi ha de caber", "OK", t.setBarco(barco1));
        assertEquals("El barco no hi ha de caber", "Ja hi ha tots els barcos",
                t.setBarco(barco2));

    }

    /**
     * Comprova que les posicions que es passen estan dins del tauler definit.
     */
    @Test
    public final void testQueElBarcoEstaDinsDelTauler() {

        String[] barco1 = {"A2"};
        String[] barco2 = {"A1"};
        String[] barco3 = {"A3"};
        String[] barco4 = {"B1"};
        String[] barco5 = {"D1"};
        t.setMaximNumeroBarcos(10);
        assertEquals("El barco ha d'entrar", "OK", t.setBarco(barco1));
        assertEquals("El barco ha d'entrar", "OK", t.setBarco(barco2));
        assertEquals("El barco no ha d'entrar", "Casella fora del tauler",
                t.setBarco(barco3));
        assertEquals("El barco ha d'entrar", "OK", t.setBarco(barco4));
        assertEquals("El barco no ha d'entrar", "Casella fora del tauler",
                t.setBarco(barco5));

    }

    /**
     * Comprova que les posicions passades són correctes donades les
     * coordenades passades i les mides del tauler.
     */
    @Test
    public final void testPosicionsCorrectes() {
        // Posició correcta (tauler 3x3
        String[] barco1 = {"B2" };
        assertEquals("OK", t.setBarco(barco1));

        // Fora del tauler
        barco1[0] = "ABCD23";
        assertEquals("Casella fora del tauler", t.setBarco(barco1));

        // Posició incorrecta
        barco1[0] = "A1B2";

        assertEquals("Això no és un barco", t.setBarco(barco1));

        // Posició incorrecta
        barco1[0] = "1B";
        assertEquals("Això no és un barco", t.setBarco(barco1));

    }

}
