package by.it.levchuk.levchuk.jd01_14;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.*;


public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {

    }

}
