package by.it.kirichenko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var evaluate(String expr){
        expr=expr.replaceAll("\\s+","");
        String[] parts=expr.split(Patterns.OPERATION,2);
        Var leftVar= VarCreator.build(parts[0]);
        if (parts.length<2){
            return leftVar;
        }

        Var rightVar= VarCreator.build(parts[1]);
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expr);
        if (matcherOperation.find()){
            String operation=matcherOperation.group();
            switch (operation){
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


        return null; //TODO exp
    }
}
