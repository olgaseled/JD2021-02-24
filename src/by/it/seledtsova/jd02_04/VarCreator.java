package by.it.seledtsova.jd02_04;

import java.util.HashMap;
import java.util.Map;

class VarCreator {

        private VarCreator() {
        }
    private static Map<String,Var> vars=new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }
    //задание jd0_09
    static Var createVar (String operand)   throws CaltExeption { // принимает не вход строку внутри оперант
        operand=operand.trim().replace("\\s+",""); // оперант очи-ся от пробелом. они замен. пустой строкой
        if (operand.matches(Patterns.SCALAR)) //оперант сообветствует регул выраж скаляра.то вернется новый скаляр в контсруктор
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        throw new CaltExeption("Невозможно создать переменную "+operand);
        // если не один из if не сработает , вернется null
    }
}
