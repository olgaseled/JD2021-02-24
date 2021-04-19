package by.it.kaminskii.jd02_06;/* created by Kaminskii Ivan
 */

import java.io.File;

public class FindPath {

    private static final String USERS_DIR = "user.dir";
    private static final String SRC_FILE = "src";

    private FindPath() {
    }

    static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USERS_DIR);
        String src = rootProject + File.separator + SRC_FILE + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }

}
