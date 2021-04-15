package by.it.runcov.jd02_04;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    static Var save(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var load(String name) {
        return vars.get(name);
    }



    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s - %s is impossible\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s * %s is impossible\n", this, other));

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s is impossible\n", this, other));
    }

    @Override
    public String toString() {
        return "abstract Var{}";
    }
}
