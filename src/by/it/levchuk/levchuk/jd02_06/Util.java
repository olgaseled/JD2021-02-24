package by.it.levchuk.levchuk.jd02_06;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.File;

public class Util {
    public static File getFile(Class<?> aClass, String fileName) {
        String packegeName = aClass.getPackageName();
        String root = System.getProperty("user.dir");
        String dir = root + File.separator + "src" + File.separator + packegeName.replace(".", File.separator);
        return new File(dir, fileName);
    }
}
