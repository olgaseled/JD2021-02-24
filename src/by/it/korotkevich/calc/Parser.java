package by.it.korotkevich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var evaluate(String expression) {
        expression = expression.replaceAll("\\s+", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        Var leftVar = VarCreator.build(parts[0]);
        if (parts.length<2) {
            return leftVar;
        }
        Var rightVar = VarCreator.build(parts[1]);
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()){
            String operation = matcherOperation.group();
            switch (operation){
                case "+": return leftVar.add(rightVar);
                case "-": return leftVar.sub(rightVar);
                case "*": return leftVar.mul(rightVar);
                case "/": return leftVar.div(rightVar);

            }
        }


        return null; //TODO stub
    }
}
