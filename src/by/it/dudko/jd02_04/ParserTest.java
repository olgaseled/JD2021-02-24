package by.it.dudko.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;


    @Before
    public void setUp() {
        parser = new Parser();
        VarRepository.load();
    }

    @Test
    public void scalarTest() throws CalcException {

        /*
            A=2+5.3 (выведет на экран 7.3)
            B=A*3.5 (выведет на экран 25.55)
            B1=B+0.11*-5  (выведет на экран 25)
            B2=A/2-1 (выведет на экран 2.65)
        */

        Var actualVar;
        double actual;
        double expected;

        actualVar = parser.evaluate("A=2+5.3");
        actual = Double.parseDouble(actualVar.toString());
        expected = 7.3;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("B=A*3.5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25.55;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("B+0.11*-5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("B2=A/2-1");
        actual = Double.parseDouble(actualVar.toString());
        expected = 2.65;
        assertEquals(expected, actual, 1e-10);


    }

    @Test
    public void parenthesesTest() throws CalcException {

        /*
            C=B+(A*2) (выведет на экран 40.15)
            D=((C-0.15)-20)/(7-5) (выведет на экран 10)
         */

        Var actualVar;
        double actual;
        double expected;

        actualVar = parser.evaluate("C=B+(A*2)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 40.15;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("D=((C-0.15)-20)/(7-5)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 10;
        assertEquals(expected, actual, 1e-10);

    }

    @After
    public void dumpVars() throws Exception {
        VarRepository.save(Var.getVars());
    }
}
