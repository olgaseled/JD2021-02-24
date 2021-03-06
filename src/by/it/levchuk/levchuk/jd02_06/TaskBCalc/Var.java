package by.it.levchuk.levchuk.jd02_06.TaskBCalc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    static Var save(String key, Var value) { vars.put(key, value);
        return value;
    }

    static Var loading(String key) { return vars.get(key);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Операция сложения " + this + "+" + other + " невозможна"));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Операция вычитания " + this + "-" + other + " невозможна"));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Операция умножения " + this + "*" + other + " невозможна"));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Операция деления " + this + "/" + other + " невозможна"));
    }

    @Override
    public String toString() {
        return "abstract Var{}";
    }
}
