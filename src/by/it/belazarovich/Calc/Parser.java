package by.it.belazarovich.Calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    @SuppressWarnings("ConstantConditions")
    Var evaluate(String expression) throws CalkExeption {
        expression = expression.replaceAll("\\s+", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);


        Var leftVar = VarCreator.build(parts[0]);
        if (parts.length < 2) {
            return leftVar;
        }


        Var rightVar = VarCreator.build(parts[1]);
        if (expression.contains("=")){
            Var.saveVar(parts [0],rightVar);

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
            }
        }

        return null; //stub
    }
}
