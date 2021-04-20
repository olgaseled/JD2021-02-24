package by.it.papruga.jd02_06.task_c;

import java.io.File;

public class FileNameHelper {

    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    private FileNameHelper(){

    }

    static String getFilePath(String filename, Class<?> currentStructure){

        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir +filename;
    }
}
