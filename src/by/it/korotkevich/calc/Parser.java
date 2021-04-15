package by.it.korotkevich.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var evaluate(String expression) throws CalcException {

        Matcher bracketsMatcher = Pattern.compile(Patterns.BRACKETS).matcher(expression);
        while (bracketsMatcher.find()) {
            String group = bracketsMatcher.group();
            String bracketsExpressionResult = String.valueOf(evaluate(group.substring(1, group.length() - 1)));
            expression = bracketsMatcher.replaceFirst(bracketsExpressionResult);
            bracketsMatcher.reset();
            bracketsMatcher = Pattern.compile(Patterns.BRACKETS).matcher(expression);
        }
        ArrayList<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        ArrayList<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            if (operations.contains("printVar")){
                Map<String, Var> vars = Var.vars;
                Var.printVar(vars);
                operations.clear();
                return null;
            }
            String operation = operations.remove(index);
            String leftOperand = operands.remove(index);
            String rightOperand = operands.remove(index);
            Var result = oneOperation(leftOperand, operation, rightOperand);
            operands.add(index, result.toString());
        }
        return VarCreator.build(operands.get(0));
    }

    private Var oneOperation(String leftOperand, String operation, String rightOperand) throws CalcException {
        Var rightVar = VarCreator.build(rightOperand);
        if (operation.equals("=")){
            return Var.saveVar(leftOperand, rightVar);
        }
        Var leftVar = VarCreator.build(leftOperand);

        switch (operation){
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
        throw new CalcException("Impossible operation");
    }

    private static final Map<String, Integer> pr = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2,
            "printVar", 3
    );

    private int getIndex(ArrayList<String> operations) {
        int index = -1;
        int best = -1;
        for (int i = 0; i < operations.size(); i++) {
            int currentPr = pr.get(operations.get(i));
            if (currentPr > best) {
                index = i;
                best = currentPr;
            }
        }
        return index;
    }
}
