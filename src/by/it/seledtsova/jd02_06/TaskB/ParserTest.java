package by.it.seledtsova.jd02_06.TaskB;


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

//C=B+(A*2)(выведет на экран 40.15).
        Var actualVar5 = parser.calc("C=25.55+(7.3*2)");
        double actual5 = Double.parseDouble(actualVar5.toString());
        double expected5 = 40.15;
        assertEquals(expected5, actual5, 1e-5);

//D=((C-0.15)-20)/(7-5) (выведет на экран 10)
        Var actualVar6 = parser.calc("D=((40.15-0.15)-20)/(7-5)");
        double actual6 = Double.parseDouble(actualVar6.toString());
        double expected6 = 10;
        assertEquals(expected6, actual6, 1e-5);

 //E={2,3}*(D/2) (выведет на экран {10,15} )
        Vector vector3 = (Vector) parser.calc("E={2,3}*(10/2)");
        double[] actual3 = vector3.getValue();
        double[] excpected3 = {10,15};
        assertArrayEquals(excpected3, actual3, 1e-5);
    }


    @Test
    public void matrixTest() {

    }

    @After
    public void tearDown() throws Exception {

    }

}