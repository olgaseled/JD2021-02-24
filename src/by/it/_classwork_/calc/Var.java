package by.it._classwork_.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var save(String key, Var value) {
        vars.put(key, value);
        return value;
    }

    static Var load(String key) {

        return vars.get(key);
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s is not possible\n", this, other);
        return null; //TODO replace throw exception
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s is not possible\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s is not possible\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s is not possible\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var{}";
    }
}
