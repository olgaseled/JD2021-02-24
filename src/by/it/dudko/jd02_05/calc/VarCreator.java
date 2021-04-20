package by.it.dudko.jd02_05.calc;

import java.util.Objects;

public class VarCreator {

    public VarCreator() {
    }

    public Var createVar(String strVar) throws CalcException {
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
        throw new CalcException(Language.INSTANCE.get(Messages.UNKNOWN_VAR_OR_EXPRESSION));
    }
}