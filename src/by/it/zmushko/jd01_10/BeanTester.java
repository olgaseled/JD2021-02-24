package by.it.zmushko.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Object obj = Bean.class.newInstance();
        String str = "";
        Method[] methods = Bean.class.getDeclaredMethods();
        for (Method method : methods) {
            Param annotation = method.getAnnotation(Param.class);
            if (annotation != null) {
                try {
                    str = (String) method.invoke(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(str);
        }

    }


}

