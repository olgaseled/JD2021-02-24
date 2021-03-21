package by.it.seledtsova.jd01_10;

import java.lang.reflect.Method;

import static java.lang.reflect.Modifier.STATIC;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods)
            if ((method.getModifiers() & STATIC) != STATIC){
            System.out.println(method.getName());
        }
    }
}
                /*
                if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) // выясним , какие из методов являются статическими.
                // Получим из каждого метода его модификатор. Если то, что у нас получилось не равняяется
                // !=Modifier.STATIC, то под if достанутся все не статические методы класса. ( их нет у нас)
                // == если заменить != на ==, то все статические
                //если модификатор заменить из STATIC на PUBLIC
            
                 */

