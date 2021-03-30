package by.it.seledtsova.jd01_13;
/*
В классе TaskBнапишите цикл, который:
+считывает данные из консоли построчнои закрывается при вводе в консоль слова END;
+переводит каждую строку в вещественное числои выводит в консоль данное число и корень из суммы всех ранее введенных чисел, включая введенное;
если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает сообщение в консоли сообщение, такого же формата, как в предыдущем задании
если невозможно извлечь корень, то обработка аналогична, но тип ошибки -ArithmeticException
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // 4 9 END
        while (true) {
            String word = scanner.next();
            arrayList.add(word);
            if (word.equals("END")) {
                break;
            }
        }
        ArrayList<Double> result = new ArrayList<Double>();
        try {
            for (String s : arrayList) {
                result.add(Double.parseDouble(s));
            }
        } catch (NumberFormatException e) {
            e.getStackTrace();
            StackTraceElement[] stackTrace = e.getStackTrace(); // стек поместики в массив
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName(); // пемененная . получили инфу о ошибке ( название и где возникла)
                    String classname = element.getClassName(); // инфа о классе, в котором возникла ошибка
                    int number = element.getLineNumber(); // номер строки , в кот ошибка
                    System.out.printf("name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d\n",
                            name, classname, number);
                    break;
                }
            }
        }
        Iterator<Double> iterator = result.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            Double element = iterator.next();
            sum = sum + element;
        }
        System.out.println(sum);
        if (sum >= 0) {
            double squareRoot = Math.sqrt(sum);
            System.out.println(squareRoot);
        } else if (sum < 0) {
            try {
            } catch (ArithmeticException e) {
                e.getStackTrace();
                StackTraceElement[] stackTrace = e.getStackTrace(); // стек поместики в массив
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName(); // пемененная . получили инфу о ошибке ( название и где возникла)
                        String classname = element.getClassName(); // инфа о классе, в котором возникла ошибка
                        int number = element.getLineNumber(); // номер строки , в кот ошибка
                        System.out.printf("name: %s\n" +
                                        "class: %s\n" +
                                        "line: %d\n",
                                name, classname, number);
                        break;
                    }
                }
            }
        }
    }
}











