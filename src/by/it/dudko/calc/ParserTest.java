package by.it.dudko.calc;

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

        actualVar = parser.evaluate("ADD_V1 = {2.2, 4.0, -8.0} + 3.3");
        expectedVar = VarCreator.createVar("{5.5, 7.3, -4.7}");
        assertVectorsAreEqual((Vector) actualVar, (Vector) expectedVar);

        actualVar = parser.evaluate("ADD_V2 = {2.2, 4.0, -8.0} + {7.1, -6.6, 0}");
        expectedVar = VarCreator.createVar("{9.3, -2.6, -8}");
        assertVectorsAreEqual((Vector) actualVar, (Vector) expectedVar);

        actualVar = parser.evaluate("ADD_V3 = {7.1, -6.6, 0} + {2.2, 4.0, -8.0}");
        expectedVar = VarCreator.createVar("{9.3, -2.6, -8}");
        assertVectorsAreEqual((Vector) actualVar, (Vector) expectedVar);

        try {
            parser.evaluate("ADD_V4 = {7.1, -6.6, 0} + {2.2, 4.0}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        actualVar = parser.evaluate("SUB_V1 = {2.2, 4.0, -8.0} - 3.3");
        expectedVar = VarCreator.createVar("{-1.1, 0.7, -11.3}");
        assertVectorsAreEqual((Vector) actualVar, (Vector) expectedVar);

        actualVar = parser.evaluate("SUB_V2 = {2.2, 4.0, -8.0} - {7.1, -6.6, 0}");
        expectedVar = VarCreator.createVar("{-4.9, 10.6, -8}");
        assertVectorsAreEqual((Vector) actualVar, (Vector) expectedVar);

        actualVar = parser.evaluate("SUB_V3 = {7.1, -6.6, 0} - {2.2, 4.0, -8.0}");
        expectedVar = VarCreator.createVar("{4.9, -10.6, 8}");
        assertVectorsAreEqual((Vector) actualVar, (Vector) expectedVar);

        try {
            parser.evaluate("SUB_V4 = {7.1, -6.6, 0} - {2.2, 4.0}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        actualVar = parser.evaluate("MUL_V1 = {4.9, -10.6, 8} * 12.55");
        expectedVar = VarCreator.createVar("{61.495, -133.03, 100.4}");
        assertVectorsAreEqual((Vector) actualVar, (Vector) expectedVar);

        actualVar = parser.evaluate("MUL_V2 = {9.0, 1} *" +
                "{{6, 2}," +
                "{3, 7}," +
                "{1, 0}}");
        expectedVar = VarCreator.createVar("{56, 34, 9}");
        assertVectorsAreEqual((Vector) actualVar, (Vector) expectedVar);

        try {
            parser.evaluate("MUL_V3 = {4.9, -10.6, 8} * {{1.8, 2, -1.5, 2.9}," +
                    "{3, 0, 4.333, -2.25}}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

    }

    private void assertVectorsAreEqual(Vector actualVar, Vector expectedVar) {
        assertArrayEquals(
                actualVar.getValue(),
                expectedVar.getValue(),
                1e-10
        );
    }


    @Test
    public void matrixTest() throws CalcException {

        /*
            Для каждого типа операции с векторами реализован соответствующий тест JUnit (на входе
            парсера – строка ввода выражения, на выходе – строка вывода результата).
            ADD_V1 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} + 3.3
                выведет {{5.5, 7.3, -4.7},{10.4, -3.3, 3.3}}
            ADD_V2 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} +
                {{5.5, 7.3, -4.7}, {10.4, -3.3, -3.3}} выведет {{7.7, 11.3, -12.7}, {17.5, -9.9, -3.3}}
            ADD_V3 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} +
                {9.3, -2.6, -8} выведет ERROR:
            ADD_V4 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} +
                {{5.5, 7.3, -4.7},{10.4, -3.3, -3.3}, {7.1, -6.6, 0}} выведет ERROR:

            SUB_V1 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} - 3.3
                выведет {{-1.1, 0.7, -11.3}, {3.8, -9.9, -3.3}}
            SUB_V2 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} -
                {{5.5, 7.3, -4.7}, {10.4, -3.3, -3.3}} выведет {{-3.3, -3.3, -3.3}, {-3.3, -3.3, 3.3}}
            SUB_V3 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} -
                {5.5, 7.3, -4.7} выведет ERROR:
            SUB_V4 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} -
                {{5.5, 7.3, -4.7},{10.4, -3.3, -3.3}, {7.1, -6.6, 0}} выведет ERROR:

            MUL_V1 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * 6.33
                выведет {{13.926, 25.32}, {44.943, -41.778}, {-20.889, 20.889}}
            MUL_V2 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * {2.2, 4.0}
                выведет {20.84, -10.78, 5.94}
            MUL_V3 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * {2.2, 4.0, 3.5}
                выведет ERROR:
            MUL_V4 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * {{20.84, -10.78, 5.94}, {5.5, 7.3, -4.7}}
                выведет {{67.848, 5.484, -5.732}, {111.664, -124.718, 73.194}, {-50.622, 59.664, -35.112}}
            MUL_V5 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * {{20.84, -10.78}, {5.5, 7.3}, {7.1, -6.6}}
                выведет ERROR:
         */

        Var actualVar;
        Var expectedVar;

        // SUM
        actualVar = parser.evaluate("ADD_V1 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} + 3.3");
        expectedVar = VarCreator.createVar("{{5.5, 7.3, -4.7},{10.4, -3.3, 3.3}}");
        assertMatricesAreEqual((Matrix) actualVar, (Matrix) expectedVar);

        actualVar = parser.evaluate("{{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} +" +
                "{{5.5, 7.3, -4.7}, {10.4, -3.3, -3.3}}");
        expectedVar = VarCreator.createVar("{{7.7, 11.3, -12.7}, {17.5, -9.9, -3.3}}");
        assertMatricesAreEqual((Matrix) actualVar, (Matrix) expectedVar);


        try {
            parser.evaluate("ADD_V3 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} + {9.3, -2.6, -8}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        try {
            parser.evaluate("ADD_V4 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} +" +
                    "{{5.5, 7.3, -4.7},{10.4, -3.3, -3.3}, {7.1, -6.6, 0}}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }


        // SUBTRACTION
        actualVar = parser.evaluate("SUB_V1 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} - 3.3");
        expectedVar = VarCreator.createVar("{{-1.1, 0.7, -11.3}, {3.8, -9.9, -3.3}}");
        assertMatricesAreEqual((Matrix) actualVar, (Matrix) expectedVar);

        actualVar = parser.evaluate("SUB_V2 = {{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} -" +
                "{{5.5, 7.3, -4.7}, {10.4, -3.3, -3.3}}");
        expectedVar = VarCreator.createVar("{{-3.3, -3.3, -3.3}, {-3.3, -3.3, 3.3}}");
        assertMatricesAreEqual((Matrix) expectedVar, (Matrix) actualVar);

        try {
            parser.evaluate("{{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} - {5.5, 7.3, -4.7}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        try {
            parser.evaluate("{{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} - " +
                    "{{5.5, 7.3, -4.7},{10.4, -3.3, -3.3}, {7.1, -6.6, 0}}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

//        exception.expect(CalcException.class);
//        exception.expectMessage("ERROR:");
//        parser.evaluate("{{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} - {5.5, 7.3, -4.7}");
//        parser.evaluate("{{2.2, 4.0, -8.0}, {7.1, -6.6, 0}} - " +
//                "{{5.5, 7.3, -4.7},{10.4, -3.3, -3.3}, {7.1, -6.6, 0}}");

        // MULTIPLICATION

        actualVar = parser.evaluate("MUL_V1 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * 6.33");
        expectedVar = VarCreator.createVar("{{13.926, 25.32}, {44.943, -41.778}, {-20.889, 20.889}}");
        assertMatricesAreEqual((Matrix) expectedVar, (Matrix) actualVar);

        actualVar = parser.evaluate("MUL_V2 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * {2.2, 4.0}");
        expectedVar = VarCreator.createVar("{20.84, -10.78, 5.94}");
        assertVectorsAreEqual((Vector) expectedVar, (Vector) actualVar);

        actualVar = parser.evaluate("MUL_V4 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * " +
                "{{20.84, -10.78, 5.94}, {5.5, 7.3, -4.7}}");
        expectedVar = VarCreator.createVar("{{67.848, 5.484, -5.732}, {111.664, -124.718, 73.194}, " +
                "{-50.622, 59.664, -35.112}}");
        assertMatricesAreEqual((Matrix) expectedVar, (Matrix) actualVar);


        try {
            parser.evaluate("MUL_V3 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * {2.2, 4.0, 3.5}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        try {
            parser.evaluate("MUL_V5 = {{2.2, 4.0}, {7.1, -6.6}, {-3.3, 3.3}} * " +
                    "{{20.84, -10.78}, {5.5, 7.3}, {7.1, -6.6}}");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

    }

    private void assertMatricesAreEqual(Matrix actualVar, Matrix expectedVar) {
        int rowsLength;
        Vector actualItem;
        Vector expectedItem;
        rowsLength = actualVar.getValue().length;
        for (int i = 0; i < rowsLength; i++) {
            actualItem = new Vector(actualVar.getValue()[i]);
            expectedItem = new Vector(expectedVar.getValue()[i]);
            assertArrayEquals(
                    actualItem.getValue(),
                    expectedItem.getValue(),
                    1e-10
            );
        }
    }


    @Test
    public void createVarTest() throws CalcException {

        String actual;
        String expected;

        // Scalar creation
        parser.evaluate("SC1 =     -9");
        actual = parser.evaluate("SC1").toString();
        expected = "-9.0";
        assertEquals(expected, actual);

        parser.evaluate("SC2 = 9.5");
        actual = parser.evaluate("SC2").toString();
        expected = "9.5";
        assertEquals(expected, actual);

        try {
            parser.evaluate("SC3 = 9 5");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        try {
            parser.evaluate("SC4 = 9. 5");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        // Vector creation
        parser.evaluate("VEC1 =     {  -5.995  ,  2.2    , 149 }");
        actual = parser.evaluate("VEC1").toString();
        expected = "{-5.995, 2.2, 149.0}";
        assertEquals(expected, actual);

        try {
            parser.evaluate("VEC2 = { -5.995,, 2.2, 149 }");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        try {
            parser.evaluate("VEC3 = { -5.995, 2.2, 149} }");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }


        // Matrix creation
        parser.evaluate("MATRIX1 = {    {   20.84   ,   -10.78  }    " +
                ", {  5.5  ,  7.3 } , { 7.1 ,  -6.6  }  }");
        actual = parser.evaluate("MATRIX1").toString();
        expected = "{{20.84, -10.78}, {5.5, 7.3}, {7.1, -6.6}}";
        assertEquals(expected, actual);

        try {
            parser.evaluate("MATRIX2 = { { 2.2, 149 }, { 2.2 2, 5 } }");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        try {
            parser.evaluate("MATRIX3 = { { 2.2, 149 }, { 2.2, 2 5.0 } }");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        try {
            parser.evaluate("MATRIX4 = { { 2.2, 149 }, { 2, 3,} }");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

        try {
            parser.evaluate("MATRIX4 = { 2.2, 149 {, { 2, 3} }");
        } catch (CalcException e) {
            assertTrue(e.getMessage().startsWith("ERROR:"));
        }

    }


    @After
    public void dumpVars() throws Exception {
        VarRepository.save(Var.getVars());
    }
}
