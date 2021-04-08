package by.it.maksimova.jd01_14;

import java.io.*;

public class TaskA {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String DATA_TASK_A_BIN = "dataTaskA.bin";
    public static final String RESULT_TASK_A_TXT = "resultTaskA.txt";

    private static String dir(Class<?> cl) {
        String path = System.getProperty(USER_DIR) + File.separator + SRC + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream(dir(TaskA.class) + DATA_TASK_A_BIN)))) {
            for (int i = 0; i < 20; i++) {
                output.write((int) (Math.random() * 25));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream input = new DataInputStream(new BufferedInputStream(
                new FileInputStream(dir(TaskA.class) +  DATA_TASK_A_BIN)));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + RESULT_TASK_A_TXT))) {
            double sum = 0;
            double count = 0;
            while (input.available() > 0) {
                int i = input.readInt();
                System.out.print(i + " ");
                out2.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
            out2.print("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
