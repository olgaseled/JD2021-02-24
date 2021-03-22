package by.it.khrolovich.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        //1.Публичные методы
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder contract = new StringBuilder();
            //System.out.println(method);
            int modifiers = method.getModifiers();
            //только публичные
            if (GetModifier(contract, modifiers)) continue;

            Class<?> returnType = method.getReturnType();
            contract
                    .append(returnType.getName())
                    .append(' ')
                    .append(method.getName())
                    .append('(');
            Class<?>[] parameterTypes = method.getParameterTypes();
            String delimiter = "";
            for (Class<?> parameterType : parameterTypes) {
                contract.append(delimiter).append(parameterType.getName());
                delimiter = ",";
            }
            contract.append(')');
            System.out.println(contract);
        }
        //публичные поля
        Field[] fields = mathClass.getDeclaredFields();

        for (Field field : fields) {
            StringBuilder contract = new StringBuilder();
            int modifiers = field.getModifiers();

            if (GetModifier(contract, modifiers)) continue;

            contract.append(field.getType()).append(" ").append(field.getName());
            System.out.println(contract);
        }
    }

    public static boolean GetModifier(StringBuilder contract, int modifiers) {
        if (Modifier.isPublic(modifiers)) {
            contract.append("public ");
        } else {
            return true;
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
        return false;
    }
}
