package by.it.kaminskii.jd01_15;/* created by Kaminskii Ivan
 */

public class Helper {
    public static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" +
                cl.getName().replace(cl.getSimpleName(), "").replace('.', '/');
    }
}
