package by.it.zmushko.jd01_15;

import java.io.File;

public class FindPath {

    private static final String USER_DIR = "user.dir";
    private static final String SRC_FILE_FOUND = "src";

    private FindPath() {
    }

    static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC_FILE_FOUND + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }

}
