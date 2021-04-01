package by.it.khrolovich.jd01_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskB {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String TASK_B_TXT = "Poem.txt";

    public static void main(String[] args) {
        String txtFile = getFilePath(TASK_B_TXT, TaskB.class);
        StringBuilder textPoem =  readFromFile(txtFile);
    }
    private static StringBuilder readFromFile(String txtFile) {
        StringBuilder text = new StringBuilder();
        try(BufferedReader bufferedReader= new BufferedReader(new FileReader(txtFile))){

            while (bufferedReader.ready()){
                text.append(bufferedReader.readLine()+" ");
            }
            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;

    }

    private static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName() //by.it._tasks_.jd01_14.TaskA
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }
}

