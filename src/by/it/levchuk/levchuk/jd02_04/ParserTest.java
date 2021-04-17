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
    public void analyze() throws CalcException {
        Var actualVar = parser.analyze("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-10);
    }

    @After
    public void tearDown() throws Exception {
    }
}