package by.it.zmushko.jd01_14;

import java.io.File;
import java.util.Arrays;


public class TaskC {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src/by/it/zmushko";

    public static void main(String[] args) {
        final File file = new File(getFilePath(TaskC.class));
        System.out.println("\n"+Arrays.toString(file.listFiles()));
    }

    public static String getFilePath(Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir;
    }

}
