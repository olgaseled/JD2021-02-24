package by.it._classwork_.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder contract = new StringBuilder();
            int modifiers = method.getModifiers();
            //9 == 0b00000000000001001
            //8 == 0b00000000000001000
            // & - (modifiers & 8)!=0
            //     0b00000000000001000
            if (Modifier.isPublic(modifiers)) {
                contract.append("public ");
            } else {
                continue;
            }
            if (Modifier.isPrivate(modifiers)) {
                contract.append("private ");
            }
            if (Modifier.isProtected(modifiers)) {
                contract.append("protected ");
            }
            if (Modifier.isStatic(modifiers)) {
                contract.append("static ");
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
                delimiter = ", ";
            }
            contract.append(')');
            System.out.println(contract);

        }
    }
}
