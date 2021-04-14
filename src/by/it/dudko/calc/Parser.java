package by.it.dudko.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var evaluate(String statement) throws CalcException {
        Matcher matcher;
        StringBuilder matchedGroup = new StringBuilder(statement);
        while (
                (matcher = Pattern.compile(Patterns.PRIORITY_GROUP).matcher(matchedGroup))
                .find()
        ) {
            int start = matcher.start();
            int end = matcher.end();
            Var groupResult = evaluate(matchedGroup.substring(start + 1, end - 1));
            matchedGroup.replace(start, end, groupResult.toString());
        }

        String singleStatement = matchedGroup.toString().replaceAll("\\s+", "");
        ArrayList<String> operands =
                new ArrayList<>(Arrays.asList(singleStatement.split(Patterns.OPERATION)));
        ArrayList<String> operators = new ArrayList<>();
        matcher = Pattern.compile(Patterns.OPERATION).matcher(singleStatement);
        while (matcher.find()) {
            operators.add(matcher.group());
        }
        while (operators.size() > 0) {
            int index = getIndex(operators);
            String operator = operators.remove(index);
            String leftOperand = operands.remove(index);
            String rightOperand = operands.remove(index);
            Var result = resultOperation(leftOperand, operator, rightOperand);
            operands.add(index, result.toString());
        }

        return VarCreator.createVar(operands.get(0));
    }

    private int getIndex(ArrayList<String> operators) {
        Map<String, Integer> priorityMap = Map.of(
                "=", 0,
                "+", 1,
                "-", 1,
                "*", 2,
                "/", 2
        );
        int index = -1;
        int highest = -1;
        for (int i = 0; i < operators.size(); i++) {
            String operator = operators.get(i);
            int current = priorityMap.get(operator);
            if (current > highest) {
                index = i;
                highest = current;
            }
        }
        return index;
    }

    private Var resultOperation(String left, String operator, String right) throws CalcException {
        Var rightVar = VarCreator.createVar(right);
        if (operator.equals("=")) {
            return Var.save(left, rightVar);
        }
        Var leftVar = VarCreator.createVar(left);

        switch (operator) {
            case "-":
                return leftVar.sub(rightVar);
            case "+":
                return leftVar.add(rightVar);
            case "*":
                return leftVar.mul(rightVar);
            case "/":
                return leftVar.div(rightVar);
        }
        throw new CalcException("Unknown operation");
    }
}

