package by.it.seledtsova.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsel { // принемает на вход некое значение

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

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION))); // получили лист оперантов
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression.replace(" ", "")); // заменили все пробелы на ""
        List<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) { // повторяя пока есть операции в массиве
            int index = getIndex(operations);
            String left = operands.remove(index); // я извлекаю из массива перед * 2 , левую часть
            String right = operands.remove(index); // извлекаю после * 2 . правую часть
            String operation = operations.remove(index);    // сама операция между ними. лежит в массиве
            Var result = calcOneOperation(left, operation, right);   // делаю одно действие , передаем туда левую ,операцию, а потом правую части
            operands.add(index, result.toString()); // размещаю результат в массив (вместо 2*2 будет 4)
        }
        return Var.createVar(operands.get(0));// когда все посчитается, результат будет лежать в елементе [0]
    }                           // чтобы обратно получить из строки переменную вызываю Var.createVar(operands.get(0)) (выше преобразовывали в строку)

    private int getIndex(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {
            String operation = operations.get(i);
            if (priority < priorityMap.get(operation)) {
                index = i;
                priority = priorityMap.get(operation);
            }
        }

        return index; // заглушка
    }


    Var calcOneOperation(String leftStr, String operation, String rightStr) throws CaltExeption { //метод калк будет вычислять выражение на вход он принемает строку


        Var right = Var.createVar(rightStr); // вторая переменная
        if (operation.equals("=")) {
            return Var.saveVar(leftStr, right);
        }
        Var left = Var.createVar(leftStr); // первая переменная
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

