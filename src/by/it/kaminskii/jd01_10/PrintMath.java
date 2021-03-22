package by.it.kaminskii.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;


public class PrintMath {
    public static void main(String[] args) {
        new PrintMath().printMathMethField(java.lang.Math.class);
    }

    void printMathMethField(Class<Math> mathClass) {
        mathClass = Math.class;
        Method[] declaredMethod = mathClass.getDeclaredMethods();
        String delim = " ";
        for (Method method : declaredMethod) {
            int modifies = method.getModifiers();
            StringBuilder mathMeth = new StringBuilder("");
            if (Modifier.isPublic(modifies)) {
                mathMeth.append(Modifier.toString(method.getModifiers()))
                        .append(delim).append(method.getReturnType()).append(delim)
                        .append(method.getName()).append("(");
                delim = "";
                for (Parameter tipePar : method.getParameters()) {
                    mathMeth.append(delim).append(tipePar.getType().getName());
                    delim = ",";
                }
                delim = " ";
                mathMeth.append(")");
                System.out.println(mathMeth);
            }
        }
        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            int modifies = field.getModifiers();
            StringBuilder mathMeth = new StringBuilder("");
            if (Modifier.isPublic(modifies)) {
                mathMeth.append(Modifier.toString(field.getModifiers()))
                        .append(delim)
                        .append(field.getType())
                        .append(delim)
                        .append(field.getName());
                System.out.println(mathMeth);
            }
        }
    }
}
