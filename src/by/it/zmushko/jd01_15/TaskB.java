package by.it.zmushko.jd01_15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// test

/*
 test
 test
 */

/**
 * test
 * test
 * test
 */

// test

/*
 test
 test
 */

/**
 * @author = це я, виталька
 * test
 * test
 * test
 */

public class TaskB {
    public static void main(String[] args) {
        final String filePath = FindPath.getFilePath("TaskB.java", TaskB.class);
        final String resultFilePath = FindPath.getFilePath("TaskB.txt", TaskB.class);
        final StringBuilder stringBuilder = new StringBuilder();
        createdStringFromFile(filePath, stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void createdStringFromFile(String filePath, StringBuilder stringBuilder) {
        try{
            Files.lines(Paths.get(filePath)).forEach(stringBuilder::append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
