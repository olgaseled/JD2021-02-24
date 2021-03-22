package by.it.kaminskii.jd01_10;

import java.lang.reflect.Method;


public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        String trying = mathClass.getName();
        Method[] declaredMethod = mathClass.getDeclaredMethods();
        for (Method method : declaredMethod) {
            int modifies = method.getModifiers();

            if ((modifies & 7) != 0) {
                trying = method.getName();
                System.out.println(trying);
            }
        }
    }
}
