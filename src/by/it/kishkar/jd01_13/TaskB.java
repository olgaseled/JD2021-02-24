package by.it.kishkar.jd01_13;

import java.util.Scanner;


public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double summary = 0;
        while (true) {


            String input = scanner.nextLine();
            if (input.equals("END") | input.equals("end") | input.equals("End")) {
                break;

            }

            try {
                double inner = Double.parseDouble(input);
                System.out.println(inner);
                summary += inner;
                double result = Math.sqrt(summary);
                System.out.println(result);
                if (summary < 0) throw new ArithmeticException();
            } catch (NumberFormatException | ArithmeticException e) {
                Class<? extends RuntimeException> exceptionStructure = e.getClass();
                String nameExceptionClass = exceptionStructure.getName();
                Class<TaskB> runnerStructure = TaskB.class;
                String nameRunnerClass = runnerStructure.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String classNameInStackTrace = stackTraceElement.getClassName();
                    if (classNameInStackTrace.equals(nameRunnerClass)) {
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf("" +
                                        " name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d\n",
                                nameExceptionClass, classNameInStackTrace, lineNumber);
                        break;
                    }
                }
            }
        }


    }
}
