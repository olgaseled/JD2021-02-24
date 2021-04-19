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
    Var actualVar;
    double actual;
    double expected;

  //  A=2+5.3 (выведет на экран 7.3)
     //       • B=A*3.5 (выведет на экран 25.55)
      //      • B1=B+0.11*-5 (выведет на экран 25)
       //     • B2=A/2-1 (выведет на экран 2.65)
    @Test
    public void scalarTest() throws CalcException {
        actualVar = parser.evaluate("A=2+5.3");
        actual = Double.parseDouble(actualVar.toString());
        expected = 7.3;
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
    }

    //C=B+(A*2) (выведет на экран 40.15)
      //      • D=((C-0.15)-20)/(7-5) (выведет на экран 10)
      //      • E={2,3}*(D/2)(выведет на экран {10,15} )
    @Test
    public void vectorTest() throws CalcException {

        actualVar = parser.evaluate("C=25.55+(7.3*2)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 40.15;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("D=((40.15-0.15)-20)/(7-5)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 10;
        assertEquals(expected, actual, 1e-10);

        actualVar = parser.evaluate("E={2,3}*(10/2)");
        String actualStr = actualVar.toString();
        String expectedVec = "{10.0, 15.0}";
        assertEquals(expectedVec, actualStr);
    }

    @Test
    public void matrixTest() throws CalcException {
        actualVar = parser.evaluate("M1={{1,2,3},{4,5,6}}*5");
        String actualMatrix = actualVar.toString();
        String expectedMatrix = "{{5.0, 10.0, 15.0}, {20.0, 25.0, 30.0}}";
        assertEquals(expectedMatrix, actualMatrix);

        actualVar = parser.evaluate("M1={1,2,3,4,5,6}+5");
        actualMatrix = actualVar.toString();
        expectedMatrix = "{6.0, 7.0, 8.0, 9.0, 10.0, 11.0}";
        assertEquals(expectedMatrix, actualMatrix);
    }

}