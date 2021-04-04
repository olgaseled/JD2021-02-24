package by.it.khrolovich.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class TaskC {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";
    private static final String RESULT_TASK_C_TXT = "resultTaskC.txt";

    public static void main(String[] args) {
        Class<TaskC> currentStructure = TaskC.class;
        String txtPath = getFilePath(RESULT_TASK_C_TXT, currentStructure);
        String rootProject = System.getProperty(USER_DIR);//здесь в IDE это корень проекта
        String dirPath = rootProject + File.separator + SRC + File.separator + "by"
                + File.separator + "it" + File.separator + "khrolovich";

        System.out.println(dirPath);
        File dir = new File(dirPath);
        try (PrintWriter printWriter = new PrintWriter(txtPath)) {
            printFiles(dir, printWriter);
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    private static void printFiles(File dir, PrintWriter printWriter){


        if (dir.isDirectory()) {
            File[] directories = dir.listFiles();
            String s;
            if(directories!=null) {
                for (File file : directories) {
                    if (file.isDirectory()) {
                        s = "dir:" + file.getName() + "\n";
                        System.out.print(s);//вывод на  консоль
                        printWriter.write(s);//вывод в файл
                        printFiles(file, printWriter);
                    } else {
                        s = "file:" + file.getName() + "\n";
                        System.out.print(s);
                        printWriter.write(s);
                    }
                }
            }
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
