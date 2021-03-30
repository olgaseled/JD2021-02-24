package by.it.khrolovich.calc;

import java.util.HashMap;
import java.util.Map;

//здесь уже нет абстрактных методов, оставляем абстрактным, чтобы нельзя было создать объект var
abstract class Var implements Operation {
    private static Map<String,Var> vars = new HashMap<>();

    public static Var save(String key, Var value) {
        vars.put(key,value);
        //сохраняет по ключу
        return value;
    }

    public static Var load(String value) {
        //загружает по ключу
        return vars.get(value);
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s+%s is impossible", this, other);//мысленно это toString
        //this - то, чей объект
        return null;//TODO replace throw exception
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s-%s is impossible", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s*%s is impossible", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s/%s is impossible", this, other);
        return null;
    }

    @Override
    public String toString() {
        //return super.toString();//вызываем стандартный метод, вывод пути
        return "abstract Var{}";
    }
}

