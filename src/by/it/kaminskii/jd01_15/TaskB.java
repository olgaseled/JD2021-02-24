package by.it.kaminskii.jd01_15;/* created by Kaminskii Ivan
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static by.it.kaminskii.jd01_15.Helper.dir;

// test to comment

/*
comment
comment
 */

/**
 * comment
 * comment
 * comment
 */

// comment

/*
 comment
 comment
 */

/**
 * comment
 * comment
 * comment
 */

public class TaskB {
    public static void main(String[] args) {
        String filePathJava = FindPath.getFilePath("TaskB.java", TaskB.class);
        String filePathTxt = FindPath.getFilePath("TaskB.txt", TaskB.class);
        StringBuilder stringBuilder = new StringBuilder();
        createdStringFromFile(filePathJava, stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void createdStringFromFile(String filePath, StringBuilder stringBuilder) {
        try(PrintWriter out2 = new PrintWriter(
                new FileWriter(
                        dir(TaskB.class) + "TaskB.txt"))) {
            Files.lines(Paths.get(filePath)).forEach(stringBuilder::append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
