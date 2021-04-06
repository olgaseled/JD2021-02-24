package by.it.khrolovich.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    public static final String MY_DIR = "khrolovich";
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String RESULT_TASK_C_TXT = "resultTaskC.txt";

    public static void main(String[] args) {
        Class<TaskC> currentStructure = TaskC.class;
        String txtPath = getFilePath(RESULT_TASK_C_TXT, currentStructure);
        String rootProject = System.getProperty(USER_DIR);//здесь в IDE это корень проекта
        String dirPath = rootProject + File.separator + SRC + File.separator + "by"
                + File.separator + "it" + File.separator + MY_DIR;

        System.out.println(dirPath);
        File dir = new File(dirPath);
        List<String> list = new ArrayList<>();

        addFilesToList(dir, list);
        printFilesToConsole(list);
        printFilesToFile(list, txtPath);
    }

    private static List<String> addFilesToList(File dir, List<String> list) {

        if (dir.isDirectory()) {
            File[] directories = dir.listFiles();
            String s;
            if (directories != null) {
                for (File file : directories) {
                    if (file.isDirectory()) {
                        s = "dir:" + file.getName() + "\n";
                        list.add(s);
                        addFilesToList(file, list);
                    } else {
                        s = "file:" + file.getName() + "\n";
                        list.add(s);
                    }
                }
            }
        }
        return list;
    }

    private static void printFilesToConsole(List<String> listForPrint) {
        for (String s : listForPrint) {
            System.out.println(s);
        }
    }

    private static void printFilesToFile(List<String> listForPrint, String txtPath) {

        try (PrintWriter printWriter = new PrintWriter(txtPath)) {
            for (String s : listForPrint) {
                printWriter.write(s);
            }
        } catch (FileNotFoundException | NullPointerException e) {
            throw new RuntimeException(e);
        }
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
