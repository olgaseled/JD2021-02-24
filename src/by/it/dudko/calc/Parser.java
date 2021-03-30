package by.it.dudko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    String OPERATIONS = "[-+*/]";

    Var evaluate(String statement) {
        statement = statement.replaceAll("\\s+", "");
        String[] operands = statement.split(OPERATIONS, 2);
        if (operands.length > 1) {
            Var leftOperand = VarCreator.createVar(operands[0]);
            Var rightOperand = VarCreator.createVar(operands[1]);
            Pattern pattern = Pattern.compile(OPERATIONS);
            Matcher matcher = pattern.matcher(statement);
            matcher.find();
            String operation = matcher.group();
            switch (operation) {
                case "-":
                    return leftOperand.sub(rightOperand);
                case "+":
                    return leftOperand.add(rightOperand);
                case "*":
                    return leftOperand.mul(rightOperand);
                case "/":
                    return leftOperand.div(rightOperand);
            }
        } else {
            // nothing to calculate
            // single operand is result itself
            return VarCreator.createVar(statement);
        }

        return null;
    }

}

