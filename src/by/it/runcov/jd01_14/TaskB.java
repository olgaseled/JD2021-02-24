package by.it.runcov.jd01_14;

import java.io.File;

public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        String filename = "Poem.txt";
        return path + clDir + filename;
    }

    public static void main(String[] args) {
    }
}
