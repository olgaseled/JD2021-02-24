package by.it.korotkevich.jd01_15;

import java.io.File;

public class Helper {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    private Helper() {

    }

    static String getFilePath(String fileName, Class<?> currentStructure) {
        String rootOfProject = System.getProperty(USER_DIR);
        String src = rootOfProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + fileName;
    }
}
