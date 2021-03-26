package by.it.seledtsova.calt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsel { // принемает на вход некое значение
    Var calc (String expression) { //метод калк будет вычислять выражение на вход он принемает строку
        //2.0*2.0
        String[] operand=expression.split(Patterns.OPERATION); // разделяет наше выражени на две части в соотвествии с паттерном операции

        Var two= Var.createVar(operand[1]); // вторая переменная
        if (expression.contains("=")) {
            Var.saveVar(operand [0], two);
        }
        Var one= Var.createVar(operand[0]); // первая переменная
        if (one==null || two==null)  // если кто-либо равен нулю
            return null; //TODO create error
        Pattern p= Pattern.compile(Patterns.OPERATION); //
        Matcher m=p.matcher(expression); // матчер получается из патерна р, который передали в выражение
        if (m.find()){ // если матвер нашел что-то,
            String operation= m.group(); // то наша операци находится в том, что он нашел
            switch (operation){ // если наша операция соответствует одному из 4-х случаев
                case "+": return one.add(two); // то матрица, скаляр или вектор +-*/ матрицу, скаляр или вектор
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null; // если ничего не вычислится, то вернется null
    }
}
