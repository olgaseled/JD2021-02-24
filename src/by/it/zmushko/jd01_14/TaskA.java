package by.it.zmushko.jd01_14;

import java.io.*;

public class TaskA {

    private static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    public static void main(String[] args) {
        Class<TaskA> currentStructure = TaskA.class;
        String dataPathTaskA = getFilePath(DATA_TASK_A_BIN, currentStructure);
        try (FileOutputStream fileOutputStream = new FileOutputStream(dataPathTaskA);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)) {
            dataOutputStream.writeInt(88);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(dataPathTaskA);
    }

    private static String getFilePath(String filename, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + filename;
    }
}
