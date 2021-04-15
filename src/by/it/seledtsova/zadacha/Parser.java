package by.it.seledtsova.zadacha;
/*
import by.it.seledtsova.jd02_04.CaltExeption;
import by.it.seledtsova.jd02_04.Patterns;
import by.it.seledtsova.jd02_04.Var;
import by.it.seledtsova.jd02_04.VarCreator;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 */

public class Parser { // принемает на вход некое значение
   /*


    Var calc(String expression) throws CaltExeption { //метод калк будет вычислять выражение на вход он принемает строку
        //2.0*2.0
        String[] operand = expression.split(Patterns.OPERATION); // разделяет наше выражени на две части в соотвествии с паттерном операции

        Var two = VarCreator.createVar(operand[1]); // вторая переменная
        if (expression.contains("=")) {
            VarCreator.saveVar(operand[0], two);
        }
        Var one = VarCreator.createVar(operand[0]); // первая переменная
        if (one == null || two == null)  // если кто-либо равен нулю

            throw new CaltExeption("Opps error");
        Pattern p = Pattern.compile(Patterns.OPERATION); //
        Matcher m = p.matcher(expression); // матчер получается из патерна р, который передали в выражение
        if (m.find()) { // если матчер нашел что-то,
            String operation = m.group(); // то наша операци находится в том, что он нашел
            switch (operation) { // если наша операция соответствует одному из 4-х случаев
                case "+":
                    return one.add(two); // то матрица, скаляр или вектор "+*-/ матрицу, скаляр или вектор
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        throw new CaltExeption("Opps error");

    }

    private static final Map<String, Integer> pr = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
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
    /*

     */

}

