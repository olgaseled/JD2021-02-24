package by.it.kaminskii.jd01_14;/* created by Kaminskii Ivan
 */

import by.it.kaminskii.jd01_09.Printer;

import java.io.*;

public class TaskA {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }


    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(
                            dir(TaskA.class) + "dataTaskA.bin"))
            );

            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try (DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir(TaskA.class) + "dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskA.class) + "resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (inputStream.available() > 0) {
                int i = inputStream.readInt();
                System.out.print(i + " ");
                out2.print(i + " ");
                sum += i;
                count++;
            }
            System.out.println('\n' + "avg=" + sum/count);
            out2.print("\navg=" + sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


//        String fileName = "dataTaskA.bin";
//        Class<TaskA> currentStructure = TaskA.class;
//        String dataTaskAPath = getFilePath(fileName, currentStructure);
//        try (DataOutputStream dataOutputStream = new DataOutputStream
//                (new BufferedOutputStream
//                        (new FileOutputStream(dataTaskAPath)))) {
//            dataOutputStream.writeInt(1);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(dataTaskAPath);
//    }
//
//    private static String getFilePath(String fileName, Class<TaskA> currentStructure) {
//        String tootProject = System.getProperty("uset.dir");
//        String src = tootProject + File.separator + "src" + File.separator;
//        String relatedPathDir = currentStructure
//                .getName()
//                .replace(currentStructure.getSimpleName(), "")
//                .replace(".", File.separator);
//        String filePath = src + relatedPathDir + fileName;
//        return src + relatedPathDir + fileName;
//    }
