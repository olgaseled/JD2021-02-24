package by.it.maksimova.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else Integer.parseInt("привет");

        } catch (NullPointerException | NumberFormatException e) {
            Class<? extends RuntimeException> exceptionStructure = e.getClass();
            String name = exceptionStructure.getName();
            Class<TaskA> nameOfClass = TaskA.class;
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
