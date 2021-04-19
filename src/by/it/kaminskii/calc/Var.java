package by.it.kaminskii.calc;


import by.it._classwork_.calc.CalcException;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static final Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }


    static Var creatVar(String operand) throws CalcExeption {
        operand = operand.trim().replaceAll("\\s", "");
//        try {
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        else if (operand.matches(Patterns.PRIORITY)){
            return null;
        }
        throw new CalcExeption("Невозможно создать " + operand);
    }


    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption("Операция сложения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption("Операция вычитания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption("Операция деления " + this + "/" + other + " невозможна");
    }

    @Override
    public String toString() {
        return "3.1415";
    }
}


//разработайте для класса Var наследника Vector с тремя конструкторами:

