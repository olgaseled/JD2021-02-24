package by.it._classwork_.jd02_04;

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
    public void scalarTest() throws CalcException {

        /*
            A=2+5.3 (выведет на экран 7.3)
            B=A*3.5 (выведет на экран 25.55)
            B1=B+0.11*-5  (выведет на экран 25)
            B2=A/2-1 (выведет на экран 2.65)
        */

        Var actualVar = parser.evaluate("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-10);




    }

    @Test
    public void scalarMulTest() throws CalcException {

        /*
            A=2+5.3 (выведет на экран 7.3)
            B=A*3.5 (выведет на экран 25.55)
            B1=B+0.11*-5  (выведет на экран 25)
            B2=A/2-1 (выведет на экран 2.65)
        */


        Var actualVar = parser.evaluate("B=A*3.5");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 25.55;
        assertEquals(expected, actual, 1e-10);


    }
}