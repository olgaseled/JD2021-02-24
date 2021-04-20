package by.it.kishkar.jd01_14;

import java.io.*;

import static by.it.kishkar.jd01_14.Test_jd01_14.dir;


public class TaskC {

    static String myFolder = "/src/by/it/kishkar";

    public static void readFiles(File baseDirectory) {
        if (baseDirectory.isDirectory()) {
            for (File file : baseDirectory.listFiles()) {
                if (file.isFile()) {
                    System.out.println("file:" + file.getName());
                } else {
                    System.out.println("dir:" + file.getName());
                    readFiles(file);
                    try (PrintWriter printWriter = new PrintWriter(
                            new FileWriter(
                                    dir(TaskA.class) + "resultTaskC.txt"))) {
                        if (file.isFile()) {
                            printWriter.println("file:" + file.getName());
                        } else {
                            printWriter.println("dir:" + file.getName());
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
                myFolder
        );
        readFiles(myDir);
    }

}

