package by.it.maksimova.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    public void Vectors () throws CalcException {
  
    }

    @After
    public void tearDown() throws Exception {
    }
}