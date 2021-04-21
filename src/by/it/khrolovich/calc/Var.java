package by.it.khrolovich.calc;

import java.util.HashMap;
import java.util.Map;

//здесь уже нет абстрактных методов, оставляем абстрактным, чтобы нельзя было создать объект var
abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    Language lang = Language.INSTANCE;

    public static Var save(String key, Var value) {
        vars.put(key, value);
        VarRepository.save(key, value);
        //сохраняет по ключу
        return value;
    }

    public static Var load(String value) {
        //загружает по ключу
        return vars.get(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(lang.get(Message.OPERATION)
                + " %s+%s " + lang.get(Message.IS_IMPOSSIBLE) + "\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(lang.get(Message.OPERATION)
                + " %s-%s " + lang.get(Message.IS_IMPOSSIBLE) + "\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(lang.get(Message.OPERATION) + " %s*%s "
                + lang.get(Message.IS_IMPOSSIBLE) + "\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(lang.get(Message.OPERATION)
                + " %s/%s " + lang.get(Message.IS_IMPOSSIBLE) + "\n", this, other));
    }

    @Override
    public String toString() {
        return "abstract Var{}";
    }
}

