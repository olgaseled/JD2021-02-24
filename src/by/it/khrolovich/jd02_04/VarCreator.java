package by.it.khrolovich.jd02_04;

import java.util.Objects;

public class VarCreator {
    public VarCreator() {
    }

    static Var build(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+","");
        if (strVar.matches(Patterns.SCALAR)){
            return  new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)){
            return  new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)){
            return  new Matrix(strVar);
        } else {
            Var var = Var.load(strVar);
            if(Objects.nonNull(var)){
                return var;
            }
            throw new CalcException("Unknown variable");
       }
    }
}
