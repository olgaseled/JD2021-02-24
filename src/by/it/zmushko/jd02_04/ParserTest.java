package by.it.zmushko.jd02_04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }
  //  A=2+5.3 (выведет на экран 7.3)
     //       • B=A*3.5 (выведет на экран 25.55)
      //      • B1=B+0.11*-5 (выведет на экран 25)
       //     • B2=A/2-1 (выведет на экран 2.65)
    @Test
    public void scalarTest() throws CalcException {
        Var actualVar = parser.evaluate("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("B=A*3.5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25.55;
        assertEquals(expected, actual, 1e-10);
        //B1=B+0.11*-5
        actualVar = parser.evaluate("B1=B+0.11*-5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25;
        assertEquals(expected, actual, 1e-10);
        //B2=A/2-1
        actualVar = parser.evaluate("B2=A/2-1");
        actual = Double.parseDouble(actualVar.toString());
        expected = 2.65;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("C=B+(A*2)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 40.15;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("D=((C-0.15)-20)/(7-5)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 10;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("E={2,3}*(D/2)");
        String actualStr = actualVar.toString();
        String expectedVec = "{10.0, 15.0}";
        assertEquals(expectedVec, actualStr);
    }

    //C=B+(A*2) (выведет на экран 40.15)
      //      • D=((C-0.15)-20)/(7-5) (выведет на экран 10)
      //      • E={2,3}*(D/2)(выведет на экран {10,15} )
    @Test
    public void vectorTest() throws CalcException {

        Var actualVar = parser.evaluate("C=B+(A*2)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        assertEquals(expected, actual, 1e-10);

        /*actualVar = parser.evaluate("D=((C-0.15)-20)/(7-5)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 10;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("E={2,3}*(D/2)");
        actual = Double.parseDouble(actualVar.toString());
        String expectedVec = "{10,15}";
        assertEquals(expectedVec, actual, 1e-10);
*/
    }

}