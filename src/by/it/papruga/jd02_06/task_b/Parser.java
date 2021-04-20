package by.it.papruga.jd02_06.task_b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Map<String, Integer> prMap = Map.of(
            "=", 0,
            "+",1,
            "-",1,
            "*",2,
            "/",2

    );

    Var evaluate(String expression) throws CalcException {

        ArrayList<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression.replace(" ", ""));
        ArrayList<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            Var result = calcOneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return VarCreator.build(operands.get(0));

    }

    private int getIndex(ArrayList<String> operations) {

        int index = -1;
        int best = -1;

        for (int i = 0; i < operations.size(); i++) {
            int currentPr = prMap.get(operations.get(i));
            if (currentPr > best) {
                index = i;
                best = currentPr;

            }
        }
        return index;
    }


    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var right = VarCreator.build(rightStr);
        if (operation.equals("=")) {

            return Var.save(leftStr, right);
        }
        Var left = VarCreator.build(leftStr);
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcException("err");
    }
}
