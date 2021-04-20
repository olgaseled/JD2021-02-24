package by.it.kaminskii.jd02_06;/* created by Kaminskii Ivan
 */

import java.io.File;

class FindPath {

    private static final String USERS_DIR = "user.dir";
    private static final String SRC_FILE = "src";

    FindPath() {
    }

    synchronized File getFilePath(Class<?> currentStructure, String filename) {
        String rootProject = currentStructure.getPackageName();
        String root=System.getProperty(USERS_DIR);
        String src = root +
                File.separator + SRC_FILE +
                File.separator +
                rootProject
                        .replace(".", File.separator);

        return new File(src, filename);
    }

}
