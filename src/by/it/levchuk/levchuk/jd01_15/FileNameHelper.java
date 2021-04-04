package by.it.levchuk.levchuk.jd01_15;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.File;

import static by.it.levchuk.levchuk.jd01_14.TaskA.USER_DIR;
import static java.awt.AlphaComposite.SRC;


public class FileNameHelper {

    static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }
}
