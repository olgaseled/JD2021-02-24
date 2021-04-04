package by.it.belazarovich.Calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();
    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar (String strVar) throws CalkExeption{
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
    return new Matrix(strVar);
        else if (vars.containsKey( strVar))
            return vars.get(strVar);
            throw  new CalkExeption("Невозможно создать "+strVar);

    }

    @Override
    public String toString() {
        return "abstract Var{}";
    }

    @Override
    public Var add(Var other) throws CalkExeption {
       throw new CalkExeption("Operation %s + %s is not possible\n", this, other);

    }

    @Override
    public Var sub(Var other) throws CalkExeption {
        throw new CalkExeption ("Operation %s - %s is not possible\n", this, other);

    }

    @Override
    public Var mul(Var other)throws CalkExeption {
        throw new CalkExeption("Operation %s * %s is not possible\n", this, other);

    }

    @Override
    public Var div(Var other)throws CalkExeption {
        throw new CalkExeption("Operation %s / %s is not possible\n", this, other);

    }
}
