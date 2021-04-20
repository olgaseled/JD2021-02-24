package by.it.kaminskii.calc;/* created by Kaminskii Ivan
 */

import java.util.HashMap;
import java.util.Map;

public class VarCreate {
    private static final Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }
//
//    static VarCreate createVar(String operand) throws CalcExeption {
//        operand = operand.trim().replaceAll("\\s", "");
//        if (operand.matches(Patterns.SCALAR))
//            return new Scalar(operand);
//        else if (operand.matches(Patterns.VECTOR))
//            return new Vector(operand);
//        else if (operand.matches(Patterns.MATRIX))
//            return new Matrix(operand);
//        else if (vars.containsKey(operand))
//            return vars.get(operand);
//        else if (operand.matches(Patterns.PRIORITY)){
//            return null;
//        }
//        throw new CalcExeption("Невозможно создать " + operand);
//    }
}
