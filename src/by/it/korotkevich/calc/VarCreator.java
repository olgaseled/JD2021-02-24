package by.it.korotkevich.calc;

import java.util.Objects;

class VarCreator {

    private VarCreator() {
    }

    static Var build(String strVar) throws CalcException {
        String strVarNoSpaces = strVar.replaceAll("\\s+", "");
        if (strVarNoSpaces.matches(Patterns.SCALAR)) {
            return new Scalar(strVarNoSpaces);
        } else if (strVarNoSpaces.matches(Patterns.VECTOR)) {
            return new Vector(strVarNoSpaces);
        } else if (strVarNoSpaces.matches(Patterns.MATRIX)) {
            return new Matrix(strVarNoSpaces);
        } else if (Var.vars.containsKey(strVarNoSpaces)) {
            Var var = Var.vars.get(strVarNoSpaces);
            if (Objects.nonNull(var)){
                return var;
            }
        }
        throw new CalcException("Unknown variable " + strVar);
    }
}
