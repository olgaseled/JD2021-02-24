package by.it.kirichenko.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");


        } catch (NumberFormatException | NullPointerException e) {
            Class<? extends RuntimeException> exceptionStructure = e.getClass();
            String nameExceptionClass = exceptionStructure.getName();
            Class<TaskA> runnerStructure = TaskA.class;
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
                            nameExceptionClass,classNameInStackTrace,lineNumber);
                    break;
                }
            }
        }
    }
}
