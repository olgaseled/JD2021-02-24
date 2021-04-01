package by.it.khrolovich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TaskA {
    private static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";

    public static void main(String[] args) {
        String fileName = DATA_TASK_A_BIN;
        Class<TaskA> currentStructure = TaskA.class;
        String filePath = getFilePath(fileName, currentStructure);
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)
        ) {
            dataOutputStream.writeInt(88);//соответствует X(большое английское)
            //dataOutputStream.writeInt(88*256*256*256+88*256*256+88*256);//TODO проверить
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                int j = random.nextInt(1000);
                dataOutputStream.writeInt(j);//увиди не числа текстовым редакторои
            }
        } catch (IOException e) {
            //e.printStackTrace();//печатаем не принтстэктрейс, а перенаправляем
            throw new RuntimeException(e);
        }
        /*catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        System.out.println(filePath);

        //чтение
        DataInputStream dataInputStream = null;//
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             DataInputStream dataInputStream1 = new DataInputStream(bufferedInputStream);) {
            List<Integer> list = new ArrayList<>();//TODO записать о
            //ArrayList<Integer> list = new ArrayList<>();
            //dataInputStream1.read();


            //printToConsole
            double sum = 0;
            for (Integer integer : list) {
                sum += integer;
                System.out.printf(" %d", integer);
            }
            System.out.printf(Locale.ENGLISH, "\navg=%f\n", sum / list.size());
            //ptintToFile
            getFilePath("", TaskA.class);
            String txtPath = "";
            try (PrintWriter printWriter = new PrintWriter(txtPath)) {

            } catch (FileNotFoundException e) {
                throw new RuntimeException("my message", e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
            }
        }

    }

    private static String getFilePath(String fileName, Class<?> currentStructure) {
        //private static String getFilePath(String fileName, Class<TaskA> currentStructure) {
        String rootProject = System.getProperty(USER_DIR);//здесь в IDE это корень проекта
        String src = rootProject + File.separator + SRC + File.separator;
        String relatedDir = currentStructure
                .getName()
                .replace(currentStructure.getSimpleName(), "")
                .replace(".", File.separator);
        String filePath = src + relatedDir + fileName;
        return filePath;
    }
}
