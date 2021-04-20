package by.it.kaminskii.jd01_15;/* created by Kaminskii Ivan
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
        final String filePathJava = FindPath.getFilePath("TaskB.java", TaskB.class);
        final String resultFilePathTxt = FindPath.getFilePath("TaskB.txt", TaskB.class);
        final StringBuilder stringBuilder = new StringBuilder();
        createdStringFromFile(filePathJava, stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void createdStringFromFile(String filePath, StringBuilder stringBuilder) {
        try {
            Files.lines(Paths.get(filePath)).forEach(stringBuilder::append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
