package by.it.levchuk.levchuk.jd02_04;

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
    public void scalarTest() throws CalcException {

// A=2+5.3 (выведет на экран 7.3)
//• B=A*3.5 (выведет на экран 25.55)
//• B1=B+0.11*-5  (выведет на экран 25)
//• B2=A/2-1 (выведет на экран 2.65)

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

        // Вариант B

//• C=B+(A*2) (выведет на экран 40.15).
//• D=((C-0.15)-20)/(7-5) (выведет на экран 10)
//• E={2,3}*(D/2) (выведет на экран {10,15} ).

        actualVar = parser.analyze("C=B+(A*2)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 40.15;
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
}