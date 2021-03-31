package by.it.korotkevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskA {

    private static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    private static final String USER_DIR = "user.dir";
    private static final String SRC = "src";

    public static void main(String[] args) {
        Class<TaskA> currentStructure = TaskA.class;
        String dataTaskAPath = getFilePath(DATA_TASK_A_BIN, currentStructure);
        try (FileOutputStream fileOutputStream = new FileOutputStream(dataTaskAPath);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)) {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                int j = random.nextInt(1000);
                dataOutputStream.writeInt(j);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataInputStream dataInputStream = null;
        try {
            List<Integer> list = new ArrayList<>();
            dataInputStream=new DataInputStream(new BufferedInputStream(new FileInputStream(dataTaskAPath)));
            while (dataInputStream.available()>0){
                list.add(dataInputStream.readInt());;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dataInputStream!=null){
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static String getFilePath(String fileName, Class<?> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName() //by.it.korotkevich.jd01_14.TaskA
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        return src + relatedDir + fileName;
    }
}