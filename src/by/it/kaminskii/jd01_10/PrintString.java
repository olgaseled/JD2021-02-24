package by.it.kaminskii.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        new PrintString().printStrName(java.lang.String.class);
    }
    void printStrName(Class<?> str){
        Method[] methods = str.getDeclaredMethods();
        for (Method method : methods){
            int modifier = method.getModifiers();
            StringBuilder name = new StringBuilder("");
            if(!Modifier.isStatic(modifier)){
                name.append(method.getName());
                System.out.println(name);
            }
        }
    }
}
