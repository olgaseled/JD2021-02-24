package by.it.belazarovich.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (/*NumberFormat*/ Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    System.out.println(element);
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(
                            "nane:%s\n" +
                                    "class: s\n" +
                                    "line: %s\n",
                            name, className, number);
break;

                }
            }
//  } catch (NullPointerException e){
            //      System.out.println(e);
        }
    }
}
