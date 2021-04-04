package by.it.kaminskii.jd01_14;/* created by Kaminskii Ivan
 */

import java.io.*;
import java.util.Objects;

import static by.it.kaminskii.jd01_14.Test_jd01_14.dir;

public class TaskC {
    public static void readFiles(File baseDirectory) {
        if (baseDirectory.isDirectory()) {
            for (File file : Objects.requireNonNull(baseDirectory.listFiles())) {
                if (file.isFile()) {
                    System.out.println("file:" + file.getName());
                } else {
                    System.out.println("dir:" + file.getName());
                    readFiles(file);
                    try(PrintWriter out2 = new PrintWriter(
                            new FileWriter(
                                    dir(TaskA.class) + "resultTaskC.txt"))) {
                        if (file.isFile()) {
                            out2.println("file:" + file.getName());
                        } else {
                            out2.println("dir:" + file.getName());
                            readFiles(file);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        File myDir = new File(System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "by" +
                File.separator + "it" +
                File.separator + "kaminskii" + File.separator);
        readFiles(myDir);
    }
}
