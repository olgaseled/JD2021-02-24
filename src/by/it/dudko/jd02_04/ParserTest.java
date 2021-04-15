package by.it.dudko.jd02_04;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;


    @Before
    public void setUp() {
        parser = new Parser();
        VarRepository.load();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

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

    @Test
    public void vectorTest() throws CalcException {

        /*
            Для каждого типа операции с векторами реализован соответствующий тест JUnit (на входе
            парсера – строка ввода выражения, на выходе – строка вывода результата).
            ADD_V1 = {2.2, 4.0, -8.0} + 3.3 выведет {5.5, 7.3, -4.7}
            ADD_V2 = {2.2, 4.0, -8.0} + {7.1, -6.6, 0} выведет {9.3, -2.6, -8}
            ADD_V3 = {7.1, -6.6, 0} + {2.2, 4.0, -8.0} выведет {9.3, -2.6, -8}
            ADD_V4 = {7.1, -6.6, 0} + {2.2, 4.0} выведет ERROR:
            SUB_V1 = {2.2, 4.0, -8.0} - 3.3 выведет {-1.1, 0.7, -11.3}
            SUB_V2 = {2.2, 4.0, -8.0} - {7.1, -6.6, 0} выведет {-4.9, 10.6, -8}
            SUB_V3 = {7.1, -6.6, 0} - {2.2, 4.0, -8.0} выведет {4.9, -10.6, 8}
            SUB_V4 = {7.1, -6.6, 0} - {2.2, 4.0} выведет ERROR:
            MUL_V1 = {4.9, -10.6, 8} * 12.55 выведет {61.495, -133.03, 100.4}
            MUL_V2 = {4.9, -10.6, 8} * {{1.8, 2, -1.5, 2.9},
                                        {3, 0, 4.333, -2.25},
                                        {2.9, 3, 3.03, 5.45}} выведет {0.22, 33.8, -29.0398, 81.66}
            MUL_V3 = {4.9, -10.6, 8} * {{1.8, 2, -1.5, 2.9},
                                        {3, 0, 4.333, -2.25}} выведет ERROR:
         */

        Var actualVar;
        Var expectedVar;
        String actual;
        String expected;

        actualVar = parser.evaluate("ADD_V1 = {2.2, 4.0, -8.0} + 3.3");
        expectedVar = VarCreator.createVar("{5.5, 7.3, -4.7}");
        assertArrayEquals(
                ((Vector) actualVar).getValue(),
                ((Vector) expectedVar).getValue(),
                1e-10
        );

        actualVar = parser.evaluate("ADD_V2 = {2.2, 4.0, -8.0} + {7.1, -6.6, 0}");
        expectedVar = VarCreator.createVar("{9.3, -2.6, -8}");
        assertArrayEquals(
                ((Vector) actualVar).getValue(),
                ((Vector) expectedVar).getValue(),
                1e-10
        );

        actualVar = parser.evaluate("ADD_V3 = {7.1, -6.6, 0} + {2.2, 4.0, -8.0}");
        expectedVar = VarCreator.createVar("{9.3, -2.6, -8}");
        assertArrayEquals(
                ((Vector) actualVar).getValue(),
                ((Vector) expectedVar).getValue(),
                1e-10
        );

        exception.expect(CalcException.class);
        exception.expectMessage("ERROR:");
        parser.evaluate("ADD_V4 = {7.1, -6.6, 0} + {2.2, 4.0}");


        actualVar = parser.evaluate("SUB_V1 = {2.2, 4.0, -8.0} - 3.3");
        expectedVar = VarCreator.createVar("{-1.1, 0.7, -11.3}");
        assertArrayEquals(
                ((Vector) actualVar).getValue(),
                ((Vector) expectedVar).getValue(),
                1e-10
        );

        actualVar = parser.evaluate("SUB_V2 = {2.2, 4.0, -8.0} - {7.1, -6.6, 0}");
        expectedVar = VarCreator.createVar("{-4.9, 10.6, -8}");
        assertArrayEquals(
                ((Vector) actualVar).getValue(),
                ((Vector) expectedVar).getValue(),
                1e-10
        );

        actualVar = parser.evaluate("SUB_V3 = {7.1, -6.6, 0} - {2.2, 4.0, -8.0}");
        expectedVar = VarCreator.createVar("{4.9, -10.6, 8}");
        assertArrayEquals(
                ((Vector) actualVar).getValue(),
                ((Vector) expectedVar).getValue(),
                1e-10
        );


        exception.expect(CalcException.class);
        exception.expectMessage("ERROR:");
        parser.evaluate("SUB_V4 = {7.1, -6.6, 0} - {2.2, 4.0}");


        actualVar = parser.evaluate("MUL_V1 = {4.9, -10.6, 8} * 12.55");
        expectedVar = VarCreator.createVar("{61.495, -133.03, 100.4}");
        assertArrayEquals(
                ((Vector) actualVar).getValue(),
                ((Vector) expectedVar).getValue(),
                1e-10
        );

        actualVar = parser.evaluate("MUL_V2 = {4.9, -10.6, 8} * {{1.8, 2, -1.5, 2.9}," +
                "{3, 0, 4.333, -2.25}," +
                "{2.9, 3, 3.03, 5.45}}");
        expectedVar = VarCreator.createVar("{0.22, 33.8, -29.0398, 81.66}");
        assertArrayEquals(
                ((Vector) actualVar).getValue(),
                ((Vector) expectedVar).getValue(),
                1e-10
        );


        exception.expect(CalcException.class);
        exception.expectMessage("ERROR:");
        parser.evaluate("MUL_V3 = {4.9, -10.6, 8} * {{1.8, 2, -1.5, 2.9}," +
                "{3, 0, 4.333, -2.25}}");

    }

    @After
    public void dumpVars() throws Exception {
        VarRepository.save(Var.getVars());
    }
}
