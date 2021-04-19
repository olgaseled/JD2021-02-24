package by.it.khrolovich.jd02_04;

import java.io.File;

public class FileNameHelper {
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";

    private FileNameHelper(){

    }

    //уберем приватность
    static String getFilePath(String fileName, Class<?> currentStructure) {
        //private static String getFilePath(String fileName, Class<TaskA> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);//здесь в IDE это корень проекта
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + fileName;
    }
}
