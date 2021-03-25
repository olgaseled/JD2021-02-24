package by.it.kaminskii.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> bean = Bean.class;
        Class<Param> param = Param.class;
        Method[] methods = bean.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder name = new StringBuilder();
            if (method.isAnnotationPresent(param)) {
                Object invObj = bean.getDeclaredConstructor().newInstance();
                name.append(method.getName());
                Param parAnot = method.getAnnotation(Param.class);
                if (parAnot != null) {
                    Object res = method.invoke(invObj, parAnot.a(), parAnot.b());
                    name.append(" ")
                            .append(res);
                }
                System.out.println(name);
            }
        }
    }
}
