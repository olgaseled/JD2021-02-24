package by.it.korotkevich.calc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {

    private static Logger logger = Logger.INSTANCE;

    static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static void printVar(Map<String, Var> saveVar) {
        Set<Map.Entry<String, Var>> setVar = saveVar.entrySet();
        Iterator<Map.Entry<String, Var>> i = setVar.iterator();
        while (i.hasNext()) {
            Map.Entry<String, Var> mapEntry = i.next();
            System.out.println(mapEntry.getKey() + "=" + mapEntry.getValue());
            logger.log(mapEntry.getKey() + "=" + mapEntry.getValue(), true);
        }
    } //TODO sortVar делается при помощи TreeMap

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
