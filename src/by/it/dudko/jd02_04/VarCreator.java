package by.it.dudko.jd02_04;

import java.util.Objects;

public class VarCreator {



    private VarCreator() {
    }

    public static Var createVar(String strVar) throws CalcException {
        // strVar = strVar.replaceAll(Patterns.SAFE_SPACES, "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            strVar = strVar.replace(" ", "");
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            strVar = strVar.replace(" ", "");
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