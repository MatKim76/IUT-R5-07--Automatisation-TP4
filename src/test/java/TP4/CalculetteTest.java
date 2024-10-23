import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculetteTest {

    private Calculette calculette;

    @Before
    public void setUp() {
        calculette = new Calculette();
    }

    @Test
    public void testAdditionSimple() {
        calculette.calculer("1.0 3 +");
        assertEquals(4.0, calculette.resultat(), 0.001);
    }

    @Test
    public void testSoustractionSimple() {
        calculette.calculer("5.0 3 -");
        assertEquals(2.0, calculette.resultat(), 0.001);
    }

    @Test
    public void testMultiplicationSimple() {
        calculette.calculer("2.0 4 *");
        assertEquals(8.0, calculette.resultat(), 0.001);
    }

    @Test
    public void testDivisionSimple() {
        calculette.calculer("10.0 2 /");
        assertEquals(5.0, calculette.resultat(), 0.001);
    }

    @Test
    public void testExpressionComplexe() {
        calculette.calculer("1.0 3 + 2 3.2 / +");
        assertEquals(4.625, calculette.resultat(), 0.001);
    }

    @Test(expected = java.util.EmptyStackException.class)
    public void testDivisionParZero() {
        calculette.calculer("5.0 0 /");
    }
}

