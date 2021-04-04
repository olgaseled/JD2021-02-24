package by.it.papruga.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TaskC {


    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }


    public static void main(String[] args) {

        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
                + "by" + File.separator + "it" + File.separator + "papruga");

        String[] dir = file.list();

        for (String s : dir) {

            System.out.println("dir:" + s);

        }

        try {
            PrintWriter out = new PrintWriter
                    (new FileWriter
                            (dir(TaskC.class) + "resultTaskC.txt"));

            for (String s : dir) {

                out.println("dir:" + s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

