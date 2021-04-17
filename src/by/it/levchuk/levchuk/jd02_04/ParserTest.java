package by.it.levchuk.levchuk.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
// A=2+5.3 (выведет на экран 7.3)
// B=A*3.5 (выведет на экран 25.55)
// B1=B+0.11*-5  (выведет на экран 25)
// B2=A/2-1 (выведет на экран 2.65)
    public void analyzeScalarTest() throws CalcException {

        Var actualVar = parser.analyze("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.analyze("B=A*3.5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25.55;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.analyze("B1=B+0.11*-5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.analyze("B2=A/2-1");
        actual = Double.parseDouble(actualVar.toString());
        expected = 2.65;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
// C=B+(A*2) (выведет на экран 40.15).
// D=((C-0.15)-20)/(7-5) (выведет на экран 10)
// E={2,3}*(D/2) (выведет на экран {10,15} )
    public void analyzeVectorTest() throws CalcException {
        Var actualVar = parser.analyze("C=B+(A*2)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.analyze("D=((C-0.15)-20)/(7-5)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 10;
        assertEquals(expected, actual, 1e-10);

        Vector actVector = (Vector) parser.analyze("E={2,3}*(D/2)");
        double[] actualVector = actVector.getValue();
        double[] expectedVector = {10, 15};
        assertArrayEquals(expectedVector, actualVector, 1e-10);
    }

    @Test
    public void analyzeMatrixTest() throws CalcException {
        Matrix matrix = (Matrix) parser.analyze("{{1,2},{8,3}}*{{1,2},{8,3}}");
        double[][] actualMatrix = matrix.getValue();
        double[][] expectedMatrix = {{17.0, 8.0}, {32.0, 25.0}};
        assertEquals(actualMatrix, expectedMatrix);
    }

    @After
    public void tearDown() throws Exception {
    }
}