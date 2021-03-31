package by.it.zmushko.jd01_13;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskB {
    public static void main(String[] args) {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.next();
            if (message.equals("END")) {
                break;
            }
            try {
                double changedMessage = Double.parseDouble(message);
                System.out.println(changedMessage);
                sum += changedMessage;
                if (sum < 0) {
                    throw new ArithmeticException();
                }
                double afterCalcSQRT = sqrt(sum);
                System.out.println(afterCalcSQRT);
            } catch (NumberFormatException | ArithmeticException e) {
                Class<? extends RuntimeException> aClass = e.getClass();
                String name = aClass.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                Class<TaskB> taskBClass = TaskB.class;
                String nameClass = taskBClass.getName();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    if (className.equals(nameClass)) {
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf("name: %s\n" +
                                "class: %s\n" +
                                "line: %d", name, taskBClass, lineNumber);
                    }
                }
                break;
            }
        }
    }
}
