package by.it.kirichenko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuffer outString = new StringBuffer();
                outString.append("public ");
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    outString.append("static ");
                }
                outString.append(method.getReturnType().getSimpleName() + " ");
                outString.append(method.getName() + "(");
                String delimiter = "";
                for (Class<?> parameterType : method.getParameterTypes()) {
                    outString.append(delimiter + parameterType.getSimpleName());
                    delimiter = ",";
                }
                outString.append(")");
                System.out.println(outString.toString());
            }
        }
        Field[] fields = structMath.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuffer outString = new StringBuffer();
                outString.append(field.getType().getSimpleName() + " ");
                outString.append(field.getName());
                System.out.println(outString.toString());
            }
        }
    }
}
