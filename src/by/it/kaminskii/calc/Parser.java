package by.it.kaminskii.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    Var calc(String expression) {
        expression=expression.replaceAll("\\s","");
        ArrayList<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        String[] operand = expression.split(Patterns.OPERATION);
        Var two = Var.creatVar(operands.get(1));
        if(operands.contains("=")){
            return Var.saveVar(operands.get(0), two);
        }

        Var one = Var.creatVar(operand[0]);
        if (one == null || two == null)
            return null;//TODO error
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return null; //TODO error
    }
}
