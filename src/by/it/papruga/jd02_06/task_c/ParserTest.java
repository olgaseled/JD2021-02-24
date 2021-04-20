package by.it.papruga.jd02_06.task_c;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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

        Vector vector = (Vector)parser.evaluate("{1,2,3}+{4,5,6}");
        double[] actualAdd = vector.getValue();
        double[] expectedAdd = {5.0, 7.0, 9.0};
        assertArrayEquals(expectedAdd, actualAdd, 1e-5);

        vector = (Vector)parser.evaluate("{1,2,3}-1");
        double[] actualSub = vector.getValue();
        double[] expectedSub = {0.0, 1.0, 2.0};
        assertArrayEquals(expectedSub, actualSub, 1e-5);

        vector = (Vector)parser.evaluate("{10,20,30}/5");
        double[] actualDiv = vector.getValue();
        double[] expectedDiv = {2.0, 4.0, 6.0};
        assertArrayEquals(expectedDiv, actualDiv, 1e-5);

        double actualMul = Double.parseDouble(parser.evaluate("{1,2,3}*{4,5,6}").toString());
        double expectedMul = 32.0;
        assertEquals(expectedMul, actualMul, 1e-5);


    }

    @Test
    public void MatrixTest() throws CalcException {

        Matrix matrix = (Matrix) parser.evaluate("{{1,2},{8,3}}*{{1,2},{8,3}}");
        double[][] actualAdd = matrix.getValue();
        double[][] expectedAdd = {{17.0, 8.0}, {32.0, 25.0}};
        assertEquals(actualAdd, expectedAdd);

    }


    @After
    public void tearDown() throws Exception {
    }
}