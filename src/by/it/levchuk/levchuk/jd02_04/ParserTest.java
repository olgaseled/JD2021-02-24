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
        Matrix matrixAdd = (Matrix) parser.analyze("{{1,2},{3,4}}+{{1,2},{3,4}}");
        double[][] actualMatrixAdd = matrixAdd.getValue();
        double[][] expectedMatrixAdd = {{2, 4}, {6, 8}};
        assertArrayEquals(expectedMatrixAdd,actualMatrixAdd);

        Matrix matrixSub = (Matrix) parser.analyze("{{5,6},{7,8}}-{{1,2},{3,4}}");
        double[][] actualMatrixSub = matrixSub.getValue();
        double[][] expectedMatrixSub = {{4, 4}, {4, 4}};
        assertEquals(actualMatrixSub, expectedMatrixSub);

        Matrix matrixMul = (Matrix) parser.analyze("{{1,2},{3,4}}*{{1,2},{3,4}}");
        double[][] actualMatrixMul = matrixMul.getValue();
        double[][] expectedMatrixMul = {{7, 10}, {15, 22}};
        assertArrayEquals(expectedMatrixMul,actualMatrixMul);
    }

    @After
    public void tearDown() throws Exception {
    }
}