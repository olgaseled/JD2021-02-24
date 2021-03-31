package by.it.runcov.jd01_14;

import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        String filename = "dataTaskA.bin";
        String rootProject = System.getProperty("user.dir");
        String src = rootProject + File.separator + "src" + File.separator;
        Class<TaskA> currentStructure = TaskA.class;
        String relatedDir = currentStructure.getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        String filePath = src + relatedDir + filename;
    }
}
