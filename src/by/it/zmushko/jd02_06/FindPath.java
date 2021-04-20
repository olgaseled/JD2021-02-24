package by.it.zmushko.jd02_06;

import java.io.File;

public class FindPath {

    private static final String USER_DIR = "user.dir";
    private static final String SRC_FILE_FOUND = "src";

    private FindPath() {
    }

    static File getFilePath(String filename, Class<?> currentStructure) {
        String packageName = currentStructure.getPackageName();
        String root = System.getProperty(USER_DIR);
        String relatedDir = root +
                File.separator +
                SRC_FILE_FOUND +
                File.separator +
                packageName.replace(".", File.separator);
        return new File(relatedDir, filename);
    }

}
