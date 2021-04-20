package by.it.seledtsova.jd02_06.TaskB;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser { // принемает на вход некое значение

    private static final Map<String, Integer> priorityMap = new HashMap<>() {
        {
            this.put("=", 0); // расставили знаки по важности
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    public Var calc(String expression) throws CaltExeption {
        //A=2+2*2-9
        expression = expression.replaceAll("\\s+", "");
        Matcher bracketsMatcher = Pattern.compile(Patterns.BRACKETS).matcher(expression);
        while (bracketsMatcher.find()) {
            String group = bracketsMatcher.group();
            String ResultExpressionWithoutParentheses = String.valueOf(calc(group.substring(1, group.length() - 1)));
            expression = bracketsMatcher.replaceFirst(ResultExpressionWithoutParentheses);
            bracketsMatcher.reset();
            bracketsMatcher = Pattern.compile(Patterns.BRACKETS).matcher(expression);
        }
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION))); // получили лист оперантов
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression.replace(" ", "")); // заменили все пробелы на ""
        List<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) { // повторяя пока есть операции в массиве
            int index = getIndex((ArrayList<String>) operations);
            String left = operands.remove(index); // я извлекаю из массива перед * 2 , левую часть
            String right = operands.remove(index); // извлекаю после * 2 . правую часть
            String operation = operations.remove(index);    // сама операция между ними. лежит в массиве
            Var result = calcOneOperation(left, operation, right);   // делаю одно действие , передаем туда левую ,операцию, а потом правую части
            operands.add(index, result.toString()); // размещаю результат в массив (вместо 2*2 будет 4)
        }
        return VarCreator.calc(operands.get(0));// когда все посчитается, результат будет лежать в елементе [0]
    }                           // чтобы обратно получить из строки переменную вызываю Var.createVar(operands.get(0)) (выше преобразовывали в строку)

    private int getIndex(ArrayList<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            int currentPr = priorityMap.get(operations.get(i));
            if (currentPr > priority) {
                index = i;
                priority = currentPr;
            }
        }
        return index;
    }


    Var calcOneOperation(String leftStr, String operation, String rightStr) throws CaltExeption { //метод калк будет вычислять выражение на вход он принемает строку
        Var right = VarCreator.calc(rightStr); // вторая переменная
        if (operation.equals("=")) {
            return Var.saveVar(leftStr, right);
        }
        Var left = VarCreator.calc(leftStr); // первая переменная
        switch (operation) { // если наша операция соответствует одному из 4-х случаев
            case "+":
                return left.add(right); // то матрица, скаляр или вектор +-*/ матрицу, скаляр или вектор
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CaltExeption("Opps error");
    }
}

