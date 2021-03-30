package by.it.korotkevich.calc;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var evaluate(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        Var leftVar = VarCreator.build(parts[0]);
        if (parts.length < 2) {
            return leftVar;
        }
        Var rightVar = VarCreator.build(parts[1]);
        if (expression.contains("=")) {
            return Var.saveVar(parts[0], rightVar);
        }
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()) {
            String operation = matcherOperation.group();
            switch (operation) {
                case "+":
                    return leftVar.add(rightVar);
                case "-":
                    return leftVar.sub(rightVar);
                case "*":
                    return leftVar.mul(rightVar);
                case "/":
                    return leftVar.div(rightVar);
                case "printVar":
                    Map<String, Var> vars = Var.vars;
                    Var.printVar(vars);
            }
        }


        return null; //TODO stub
    }
}
