package by.it.khrolovich.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaskB {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String TASK_B_TXT = "Poem.txt";

    String txtFile = getFilePath(TASK_B_TXT, TaskB.class);
    List<Integer> list =  readFromFile(txtFile);

    private List<Integer> readFromFile(String txtFile) {
        return new ArrayList<>();
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
