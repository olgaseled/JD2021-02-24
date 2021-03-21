package by.it.seledtsova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> structMath = Math.class; //мы получили класс Math и занесли нам класс в переменную
        Method[] methods = structMath.getDeclaredMethods();// написали команду, для всех методов. ЗАписана как массив методов
        for (Method method : methods) { // переберем все методы
            if ((method.getModifiers() &Modifier.PUBLIC) ==Modifier.PUBLIC) // выясним , какие из методов являются статическими.
                                        // Получим из каждого метода его модификатор. Если то, что у нас получилось не равняяется
                                       // !=Modifier.STATIC, то под if достанутся все не статические методы класса. ( их нет у нас)
                                        // == если заменить != на ==, то все статические
                                        //если модификатор заменить из STATIC на PUBLIC
                System.out.println(method);

        }

    }







}
    /*
}
    public static void main(String[] args) { //Class<?> stringClass = String.class;
    Class<Math> mathClass = Math.class; // ctrl-alt-v  или .var ( посмотри в refactor -extract/introduce )
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method: methods) {
            StringBuilder contract = new StringBuilder();
            int modifiers = method.getModifiers();
            // System.out.println(method); // напечатались все методы , которые есть
            if (Modifier.isPrivate(modifiers)) {
                contract.append("private");
            }
            if (Modifier.isStatic(modifiers)) {
                contract.append("static");
            }
            if (Modifier.isPublic(modifiers)) {
                contract.append("public");
            } esle
                        continue;

            if (Modifier.isProtected(modifiers))
                contract.append("protected"); {
            }
            Class <?> returnTupe = method.getReturnType();
            contract
                    .append(returnTupe.getSimpleName())
                    .append(' ')
                    .append(method.getName())
                    .append('(');
           Class <?> [] parameterTypes=method
                    String delimiter=",";
           for (Class <?>) paramertTypes



     */
