package by.it.dudko.calc;

import java.util.Objects;

public class VarCreator {



    private VarCreator() {
    }

    public static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replace(" ", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var savedVar = Var.load(strVar);
            if (Objects.nonNull(savedVar)) {
                return savedVar;
            }
        }
        throw new CalcException("Unknown variable or expression: " + strVar);
    }
}