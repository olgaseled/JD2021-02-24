package by.it.kishkar.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> classMath = Math.class;
        Method[] methods = classMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(method.toString().replaceAll("java.lang.Math.", "")); //print all exclude import's words
            System.out.println("double E");
            System.out.println("double PI");
        }

    }
}
