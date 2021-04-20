package by.it.dudko.jd02_05.calc;

import java.io.File;
import java.util.StringJoiner;

public class FileNameHelper {
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    private FileNameHelper() {
    }

    public static String getFullPath(String target, Class<?> struct) {
        String classRelPath = struct.getName()
                .replace("." + struct.getSimpleName(), "")
                .replace(".", File.separator);
        StringJoiner classFullPath = new StringJoiner(File.separator);
        return classFullPath
                .add(System.getProperty(USER_DIR))
                .add(SRC)
                .add(classRelPath)
                .add(target)
                .toString();
    }
}
