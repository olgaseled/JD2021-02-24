package by.it.levchuk.levchuk.calc;

import java.util.Objects;

public class VarCreator {

    private VarCreator() {
    }

    static Var build(String strVar) throws CalcException {

        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var var =  Var.loading(strVar);
            if (Objects.nonNull(var)) {
                return var;
            }
        }
        throw new CalcException("Неизвестная переменная или выражение: " + strVar);
    }
}




