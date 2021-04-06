package by.it.dudko.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.StringJoiner;

public class TaskC {

    private static final String USER_DIR = "user.dir";
    private static final String FILE_SEPARATOR = "file.separator";
    private static final String SRC = "src";
    private static final String RESULT_TASK_C_TXT = "resultTaskC.txt";

    private final File baseDir;
    private BufferedWriter bufferedWriter;

    private TaskC(String path) {
        baseDir = new File(path);
        if (!(baseDir.exists() && baseDir.canRead() && baseDir.isDirectory())) {
            throw new RuntimeException("Directory doesn't exist or access isn't allowed");
        }
        bufferedWriter = null;
    }

    public static void main(String[] args) {
        String resultPath = getFullPath(RESULT_TASK_C_TXT, TaskC.class);
        String searchPath = resultPath.replaceFirst("jd01_14.*", "");

        TaskC dirScanner = new TaskC(searchPath);
        try {
            dirScanner.prepareToWrite(resultPath);
            dirScanner.scan();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void prepareToWrite(String resultPath) throws IOException {
        FileWriter resultFile = new FileWriter(resultPath);
        bufferedWriter = new BufferedWriter(resultFile);
    }


    private void scan() throws IOException {
        processDir(baseDir);
    }


    private void processDir(File dir) throws IOException {
        String outputLine;
        String absPathToDir = dir.getAbsolutePath() + System.getProperty(FILE_SEPARATOR);
        String[] dirContents = dir.list();
        if (!(dir.exists() && dir.canRead() && dirContents != null)) {
            throw new RuntimeException("File or directory doesn't exist or access isn't allowed");
        }
        outputLine = String.format("dir:%s\n", dir.getName());
        System.out.print(outputLine);
        bufferedWriter.write(outputLine);
        bufferedWriter.flush();

        for (String path : dirContents) {
            File fsObject = new File(absPathToDir + path);
            if (fsObject.isDirectory()) {
                processDir(fsObject);
            } else {
                if (Objects.isNull(bufferedWriter)) continue; // output to file is disabled
                outputLine = String.format("file:%s\n", fsObject.getName());
                System.out.print(outputLine);
                bufferedWriter.write(outputLine);
                bufferedWriter.flush();
            }
        }
    }

    public static String getFullPath(String target, Class<?> struct) {
        String projectRoot = System.getProperty(USER_DIR);
        String fileSeparator = System.getProperty(FILE_SEPARATOR);
        String classSimpleName = struct.getSimpleName();
        String classRelPath = struct.getName()
                .replace(classSimpleName, "")
                .replace(".", fileSeparator);
        StringJoiner classFullPath = new StringJoiner(fileSeparator);
        return classFullPath
                .add(projectRoot)
                .add(SRC)
                .add(classRelPath)
                .add(target).toString();
    }
}
