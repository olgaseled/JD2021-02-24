package by.it.zmushko.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;


public class TaskC {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src/by/it/zmushko";
    public static final String RESULT_TASK_C_TXT = "resultTaskC.txt";
    private static final String SRC_FILE_FOUND = "src";

    public static void main(String[] args) {
        String txtPath = getFilePath(RESULT_TASK_C_TXT, TaskC.class);
        printInFile(txtPath);
        System.out.println(getAllDirectoryAndFiles());
    }

    private static void printInFile(String txtPath) {
        try (PrintWriter printWriter = new PrintWriter(txtPath)){
            printWriter.print(getAllDirectoryAndFiles());
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }

    private static StringBuilder getAllDirectoryAndFiles() {
        final File file = new File(getFilePath());
        StringBuilder stringBuilder = new StringBuilder();
        File[] fileList = file.listFiles();
        for (File file1 : Objects.requireNonNull(fileList)) {
            stringBuilder.append("dir:").append(file1.getName()).append("\n");
            File[] files = file1.listFiles();
            for (File file2 : Objects.requireNonNull(files)) {
                stringBuilder.append("file:").append(file2.getName()).append("\n");
            }
        }
        return stringBuilder;
    }

    public static String getFilePath() {
        return System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
    }

    public static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC_FILE_FOUND + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }

}
