package by.it.papruga.jd02_04;

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
    public void ScalarTest() throws CalcException {

        Var actualVar = parser.evaluate("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-5);

        actual = Double.parseDouble(parser.evaluate("B=A*3.5").toString());
        expected = 25.55;
        assertEquals(expected, actual, 1e-5);

        actual = Double.parseDouble(parser.evaluate("B1=B+0.11*-5").toString());
        expected = 25;
        assertEquals(expected, actual, 1e-5);

        actual = Double.parseDouble(parser.evaluate("B2=A/2-1").toString());
        expected = 2.65;
        assertEquals(expected, actual, 1e-5);

    }
    @Test
    public void VectorTest() throws CalcException {

        Vector vector = (Vector)parser.evaluate("V={1,2,3}+{4,5,6}");
        double[] actual = vector.getValue();
        double[] expected = {5.0, 7.0, 9.0};
        assertArrayEquals(expected, actual, 1e-5);

    }
    @After
    public void tearDown() throws Exception {
    }
}