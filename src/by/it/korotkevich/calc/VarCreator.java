package by.it.korotkevich.calc;

import java.util.Objects;

class VarCreator {

    private VarCreator() {
    }

    static Var build(String strVar) throws CalcException {
        strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (Var.vars.containsKey(strVar)) {
            Var var = Var.vars.get(strVar);
            if (Objects.nonNull(var)){
                return var;
            }
        }
        throw new CalcException(); //TODO fix this
    }
}
