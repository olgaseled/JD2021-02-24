package by.it.zmushko.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random()>0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            Class<? extends RuntimeException> exceptionStructure = e.getClass();
            String name = exceptionStructure.getName();
            System.out.println("name: " + name);
            Class<TaskA> runStruct = TaskA.class;
            String name1 = runStruct.getName();
           // System.out.println(name1);
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String classNameInStackTrace = stackTraceElement.getClassName();
                if (classNameInStackTrace.equals(name1)) {
                    int lineNumber = stackTraceElement.getLineNumber();
                    System.out.println("class: " + stackTraceElement);
                    System.out.println("line: " + lineNumber);
                    break;
                }
            }
        }
    }
}
