package by.it.khrolovich.jd01_15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TaskB {
    public static void main(String[] args) {
        String fileName = FileNameHelper.getFilePath("TaskB.java", TaskA.class);
        String fileNameTXT = FileNameHelper.getFilePath("TaskB.txt", TaskA.class);
        System.out.println(fileName);
        Stream<String> lines = null;
        StringBuilder sb = new StringBuilder();
        try {
            Files.lines(Paths.get(fileName)).forEach(s->sb.append(s).append('\n'));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sb);
    }
}
