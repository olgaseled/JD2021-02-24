package by.it.seledtsova.jd02_04;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }


    @Test
    public void scalarTest() throws CaltExeption {

        // A=2+5.3 (выведет на экран 7.3)
        Var actualVar1 = parser.calc("A=2+5.3"); // будем вводить
        double actual1 = Double.parseDouble(actualVar1.toString());
        double expected1 = 7.3; // ожидаем
        assertEquals(expected1, actual1, 1e-5);  // дельта , так как числа double

        // B=A*3.5 (выведет на экран 25.55)
        Var actualVar2 = parser.calc("B=A*3.5");
        double actual2 = Double.parseDouble(actualVar2.toString());
        double expected2 = 25.55;
        assertEquals(expected2, actual2, 1e-5);

        // B1=B+0.11*-5 (выведет на экран 25)
        Var actualVar3 = parser.calc("B1=B+0.11*-5");
        double actual3 = Double.parseDouble(actualVar3.toString());
        double expected3 = 25;
        assertEquals(expected3, actual3, 1e-5);

        // B2=A/2-1 (выведет на экран 2.65)
        Var actualVar4 = parser.calc("B2=A/2-1");
        double actual4 = Double.parseDouble(actualVar4.toString());
        double expected4 = 2.65;
        assertEquals(expected4, actual4, 1e-5);

    }

    @Test
    public void vectorTest() throws CaltExeption {
        Vector vector = (Vector) parser.calc("V={1,2,3}+{4,5,6}");
        double[] actual = vector.getValue();
        double[] excpected = {5, 7, 9};
        assertArrayEquals(excpected, actual, 1e-5);


        Vector vector1 = (Vector) parser.calc("C={1,2,3}*5");
        double[] actual1 = vector1.getValue();
        double[] excpected1 = {5,10,15};
        assertArrayEquals(excpected1, actual1, 1e-5);


        Vector vector2 = (Vector) parser.calc("D={27,15,21}/3.0");
        double[] actual2 = vector2.getValue();
        double[] excpected2 = {9,5,7};
        assertArrayEquals(excpected2, actual2, 1e-5);

        Vector vector3 = (Vector) parser.calc("E={1,2,3}+7");
        double[] actual3 = vector3.getValue();
        double[] excpected3 = {8,9,10};
        assertArrayEquals(excpected3, actual3, 1e-5);



    }

   @Test
    public void matrixTest() {

    }

    @After
    public void tearDown() throws Exception {

    }

}