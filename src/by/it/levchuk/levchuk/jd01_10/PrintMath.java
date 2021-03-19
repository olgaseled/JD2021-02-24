package by.it.levchuk.levchuk.jd01_10;

import java.lang.reflect.Method;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method:methods);{
           // System.out.println(method);
           // int modifires = methods.getClass();
            //8==0b//
           // if ((modifires & 1)!=0);
           // System.out.println(method);
        }

    }
}
