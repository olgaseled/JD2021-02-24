package by.it.kishkar.jd01_10;

import javax.sound.midi.MetaEventListener;
import java.lang.reflect.Method;

import static java.lang.reflect.Modifier.PUBLIC;
import static java.lang.reflect.Modifier.STATIC;

public class PrintString {
    public static void main(String[] args) {
        Class<String> StrClass = String.class;
        Method[] methods = StrClass.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & STATIC) != STATIC) {
                System.out.println(method.getName());
            }
        }
    }
}