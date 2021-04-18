package by.it.khrolovich.jd02_04;

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
    public void ScalarTest() throws CalcException {
        //test sum
        Var actualVar = parser.evaluate("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-10);

        //test mul
        actualVar = parser.evaluate("B=A*3.5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25.55;
        assertEquals(expected, actual, 1e-10);

        //test sub+mul
        actualVar = parser.evaluate("B1=B-0.11*5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25;
        assertEquals(expected, actual, 1e-10);

        //test div+sub
        actualVar = parser.evaluate("B2=A/2-1");
        actual = Double.parseDouble(actualVar.toString());
        expected = 2.65;
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void VectorTest() throws CalcException {

        //test sum
        Var actualVar = parser.evaluate("A=2+{2,2}");
        String actual = actualVar.toString();
        String expected = "{4.0, 4.0}";
        assertEquals("Операция A=2+{2,2} работает некорректно",expected, actual);

        /*test sum
        Vector actualVar = (Vector)parser.evaluate("A=2+{2,2}");
        double[] actual = actualVar.getValue();
        double[] expected = new double[]{4,4};
        assertArrayEquals(expected, actual, 1e-10);*/

        actualVar = parser.evaluate("{4,4}+{2,2}");
        actual = actualVar.toString();
        expected = "{6.0, 6.0}";
        assertEquals("Операция {4,4}+{2,2} работает некорректно",expected, actual);

        //test sub
        actualVar = parser.evaluate("A=4-{2,2}");
        actual = actualVar.toString();
        expected = "{2.0, 2.0}";
        assertEquals("Операция A=4-{2,2} работает некорректно",expected, actual);

        actualVar = parser.evaluate("{4,4}-{2,2}");
        actual = actualVar.toString();
        expected = "{2.0, 2.0}";
        assertEquals("Операция {4,4}*{2,2} работает некорректно",expected, actual);

        //test mul
        actualVar = parser.evaluate("A=4*{2,2}");
        actual = actualVar.toString();
        expected = "{8.0, 8.0}";
        assertEquals("Операция A=4*{2,2} работает некорректно",expected, actual);

        actualVar = parser.evaluate("{4,4}*{2,2}");
        actual = actualVar.toString();
        expected = "16.0";
        assertEquals("Операция {4,4}*{2,2} работает некорректно",expected, actual);

        //test div
        actualVar = parser.evaluate("A={4,4}/2");
        actual = actualVar.toString();
        expected = "{2.0, 2.0}";
        assertEquals("Операция A={4,4}/2 работает некорректно",expected, actual);
    }

    @Test
    public void MatrixTest() throws CalcException{
        //test sum
        Var actualVar = parser.evaluate("A=2+{{2,2},{3,3}}");
        String actual = actualVar.toString();
        String expected = "{{4.0, 4.0}, {5.0, 5.0}}";
        assertEquals("Операция A=2+{{2,2},{3,3}} работает некорректно",expected, actual);

        actualVar = parser.evaluate("{{1,1},{1,2}}+{{2,2},{3,3}}");
        actual = actualVar.toString();
        expected = "{{3.0, 3.0}, {4.0, 5.0}}";
        assertEquals("Операция {{1,1},{1,2}}+{{2,2},{3,3}} работает некорректно",expected, actual);

        //test sub
        //actualVar = parser.evaluate("A=2-{{2,2},{3,3}}");
        actualVar = parser.evaluate("A=4-{{2,2},{3,3}}");
        actual = actualVar.toString();
        expected = "{{2.0, 2.0}, {1.0, 1.0}}";
        assertEquals("Операция A=4-{{2,2},{3,3}} работает некорректно",expected, actual);

        actualVar = parser.evaluate("{{1,1},{1,2}}-{{2,2},{3,3}}");
        actual = actualVar.toString();
        expected = "{{-1.0, -1.0}, {-2.0, -1.0}}";
        assertEquals("Операция {{1,1},{1,2}}-{{2,2},{3,3}} работает некорректно",expected, actual);

        //test mul
        actualVar = parser.evaluate("A=4*{{2,2},{3,3}}");
        actual = actualVar.toString();
        expected = "{{8.0, 8.0}, {12.0, 12.0}}";
        assertEquals("Операция A=4*{{2,2},{3,3}} работает некорректно",expected, actual);

        actualVar = parser.evaluate("A={{2,2},{3,3}}*{4,4}");
        actual = actualVar.toString();
        expected = "{16.0, 24.0}";
        assertEquals("Операция A={4,4}*{{2,2},{3,3}} работает некорректно",expected, actual);

        actualVar = parser.evaluate("{{1,1},{1,2}}*{{2,2},{3,3}}");
        actual = actualVar.toString();
        expected = "{{5.0, 5.0}, {8.0, 8.0}}";
        assertEquals("Операция {{1,1},{1,2}}*{{2,2},{3,3}} работает некорректно",expected, actual);
    }

    @Test
    public void VarCreatorTest() throws CalcException {
        //test create scalar
        Var actualVar = VarCreator.build("5");
        String actual = actualVar.toString();
        String expected = "5.0";
        assertEquals("Создание переменной типа Scalar из строки 5 работает некорректно",expected, actual);

        //test create scalar
        actualVar = VarCreator.build("{5,5}");
        actual = actualVar.toString();
        expected = "{5.0, 5.0}";
        assertEquals("Создание переменной типа Vector из строки {5,5} работает некорректно",expected, actual);

        //test create scalar
        actualVar = VarCreator.build("{{4,4},{5,5}}");
        actual = actualVar.toString();
        expected = "{{4.0, 4.0}, {5.0, 5.0}}";
        assertEquals("Создание переменной типа Matrix из строки {{4,4},{5,5}} работает некорректно",expected, actual);

    }
}