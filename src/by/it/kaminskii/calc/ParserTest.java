package by.it.kaminskii.calc;

import by.it._classwork_.calc.CalcException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser=new Parser();
    }

    @Test
    public void addTest() throws CalcExeption {
        Var actualScalar = parser.calc("2+2+7+8");
        double actual = Double.parseDouble(actualScalar.toString());
        double  expected = 19.0;
        assertEquals(expected,actual,1e-5);
    }

    public void expressionScalars() {

    }

    public void expressionVectors() {
    }

    @After
    public void tearDown() throws Exception {

    }
}