package by.it.seledtsova.jd01_13;

import java.util.HashMap;
/*
программно обработайте исключения: определите и выведите в консольимя исключения,имя класса,номер строки класса TaskA в которой это исключение возникло.
формат вывода name: java.lang.NullPointerException
class: by.it.вашпакет.jd01_13.TaskA
line: 8
никаких других данных выводиться не должно.
 */

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет"); // преобразует строку в число
        } catch (NumberFormatException | NullPointerException e) { // e.printStackTrace(); в консоле распечатаются все наши ошибки
            e.getStackTrace(); // метод возв массив всех стектрейсов, кот в классе и модуле, в кот произвошла ошибка
            StackTraceElement[] stackTrace = e.getStackTrace(); // занесем в массив наш стектрейс
            for (StackTraceElement element : stackTrace) { //распечатаем все , что есть в стектрейсе System.out.println(element);
                if (TaskA.class.getName().equals(element.getClassName())) { //имя класса в элементы совпадает с ошибкой в такс А
                    System.out.println(element);
                    String name = e.getClass().getName(); // пемененная . получили инфу об ошибке ( название и где возникла)
                    String classname = element.getClassName(); // инфа о классе, в котором возникла ошибка
                    int number = element.getLineNumber(); // номер строки , в кот. ошибка
                    System.out.printf("name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d\n",
                            name, classname, number);
                    break;// прервем цикл, что не обрабатывались остальые элементы массива stactrace
                }
            }
        }
    }
}

