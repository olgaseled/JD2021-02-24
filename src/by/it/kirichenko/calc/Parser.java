package by.it.kirichenko.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    @SuppressWarnings("ConstantConditions")
    Var evaluate(String expression) throws CalcException {
        ArrayList operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher=Pattern.compile(Patterns.OPERATION).matcher(expression);
        ArrayList<String> operations = new ArrayList<>();
        while(matcher.find()){
            operations.add(matcher.group());
        }
        while (operations.size()>0){
            int index=getIndex(operations);
            //TODO
        }

        expression = expression.replaceAll("\\s+", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        //A=2
        if (parts.length < 2) {
            return VarCreator.build(expression);
        }
        Var rightVar = VarCreator.build(parts[1]);
        if (expression.contains("=")) {
            return Var.save(parts[0], VarCreator.build(parts[1]));
        }
        Var leftVar = VarCreator.build(parts[0]);

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

    private int getIndex(ArrayList<String> operations) {
        return 0; //TODO
    }
}
