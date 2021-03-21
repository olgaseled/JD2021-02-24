package by.it.seledtsova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> structMath = Math.class; //мы получили класс Math и занесли нам класс в переменную
        Method[] methods = structMath.getDeclaredMethods();// написали команду, для всех методов. ЗАписана как массив методов
        for (Method method : methods) { // переберем все методы
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(method.toString().replace("java.lang.Math.", ""));
        }
        System.out.println("double E");
        System.out.println("double PI");

    }
}
// выясним , какие из методов являются статическими.
// Получим из каждого метода его модификатор. Если то, что у нас получилось не равняяется
// !=Modifier.STATIC, то под if достанутся все не статические методы класса. ( их нет у нас)
// == если заменить != на ==, то все статические