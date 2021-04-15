package by.it.levchuk.levchuk.jd02_04;

import java.util.Objects;

public class VarCreator {

    private VarCreator() {
    }

    static Var build(String strVar) throws CalcException {

        String strVarNew = strVar.replaceAll("\\s+", "");
        if (strVarNew.matches(Patterns.SCALAR)) {
            return new Scalar(strVarNew);
        } else if (strVarNew.matches(Patterns.VECTOR)) {
            return new Vector(strVarNew);
        } else if (strVarNew.matches(Patterns.MATRIX)) {
            return new Matrix(strVarNew);
        } else if (Var.vars.containsKey(strVarNew)) {
            Var var = Var.vars.get(strVarNew);
            if (Objects.nonNull(var)) {
                return var;
            }
        }
        throw new CalcException("Неизвестная переменная или выражение: " + strVar);
    }
}




