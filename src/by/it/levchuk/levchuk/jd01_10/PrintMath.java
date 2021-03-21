package by.it.levchuk.levchuk.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder contract = new StringBuilder();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                contract.append("public ");
            } else {
                continue;
            }
            if (Modifier.isPrivate(modifiers)) {
                contract.append("private ");
            }
            if (Modifier.isStatic(modifiers)) {
                contract.append("static ");
            }
            if (Modifier.isProtected(modifiers)) {
                contract.append("protected ");
            }
            Class<?> returnType = method.getReturnType();
            contract
                    .append(returnType.getSimpleName())
                    .append(' ')
                    .append(method.getName())
                    .append('(');
            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {
                contract.append(delimiter).append(parameterType.getSimpleName());
                delimiter = ",";
            }
            contract.append(")");
            System.out.println(contract);
        }
        Class<Math> mathClass1 = Math.class;
        Field[] fields = mathClass1.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {

                System.out.println("double " + field.getName());
            }
        }
    }
}