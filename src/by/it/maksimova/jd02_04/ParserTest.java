package by.it.maksimova.jd02_04;

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
    public void Scalars() throws CalcException {
        Var actualScalar = parser.evaluate("A=2+5.3");
        double actual = Double.parseDouble(actualScalar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-5);

        actual = Double.parseDouble(parser.evaluate("B=A*3.5").toString());
        expected = 25.55;
        assertEquals(expected, actual, 1e-5);

        actual = Double.parseDouble(parser.evaluate("B1=B+0.11*-5").toString());
        expected = 25.0;
        assertEquals(expected, actual, 1e-5);

        actual = Double.parseDouble(parser.evaluate("B2=A/2-1").toString());
        expected = 2.65;
        assertEquals(expected, actual, 1e-5);



    }

    @Test
    public void Brackets () throws CalcException {

        Var actualVar = parser.evaluate("C=B+(A*2)");
        double  actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        assertEquals(expected, actual, 1e-10);

    }

@Test
    public void Vectors () throws CalcException {


        Vector vector = (Vector) parser.evaluate("V={1,2}+{3,4}");
        double[] actualVector = vector.getValue();
        double[] expectedVector = {4,6};
        assertArrayEquals(expectedVector,actualVector,1e-5);



    }

    @After
    public void tearDown() throws Exception {
    }
}