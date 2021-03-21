package by.it.papruga.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {

    public static void main(String[] args) {

        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                String name = method.getName();
                Class<?>[] types = method.getParameterTypes();
                String returnType = method.getReturnType().getSimpleName();

                System.out.printf("public static %s %s%s\n", returnType, name, Arrays.toString(types)
                        .replace("[", "(")
                        .replace("]", ")")
                        .replace(" ", ""));
            }

        }

        Field[] fields = structMath.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) { ;

                System.out.println("double " + field.getName());
            }


        }

    }
}
