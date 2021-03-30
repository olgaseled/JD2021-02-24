package by.it.maksimova.jd01_13;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (true) { //считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
            System.out.println("Type smth, 'END' to stop:");
            String typed = scanner.nextLine();
            if (typed.trim().equals("END")) {
                break;
            }
            // NumberFormatException
            try {
                double v = Double.parseDouble(typed);
                System.out.println(v); //выводит в консоль данное число
                sum += v;//переводит каждую строку в вещественное число
                double sqRoot = Math.sqrt(sum);
                System.out.println(sqRoot); // выводит корень из суммы всех ранее введенных чисел
if (sum<0) throw new ArithmeticException (); //если невозможно извлечь корень, то обработка аналогична, но тип ошибки -ArithmeticException
            } catch (NumberFormatException | ArithmeticException e) { // ловит ошибку и выводит ее на консоль
                Class<? extends RuntimeException> exceptionStructure = e.getClass();
                String name = exceptionStructure.getName();
                Class<TaskB> nameOfClass = TaskB.class;
                String nameOfClassInStackTrace = nameOfClass.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    if (className.equals(nameOfClassInStackTrace)) {
                        int lineNumber = element.getLineNumber();
                        System.out.printf(" name: %s\nclass: %s\n line: %d\n",
                                name, className, lineNumber);
                        break;
                    }
                }
            }
            }
        }
    }





