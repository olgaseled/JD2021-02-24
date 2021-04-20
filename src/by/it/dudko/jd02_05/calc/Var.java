package by.it.dudko.jd02_05.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    public static Var save(String name, Var value) {
        vars.put(name, value);
        return value;
    }

    public static Var load(String key) {
        return vars.get(key);
    }

    @Override
    public String toString() {
        return Language.INSTANCE.get(Messages.ABSTRACT_VAR);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(Language.INSTANCE.get(Messages.UNSUPPORTED));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(Language.INSTANCE.get(Messages.UNSUPPORTED));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(Language.INSTANCE.get(Messages.UNSUPPORTED));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(Language.INSTANCE.get(Messages.UNSUPPORTED));
    }

}
