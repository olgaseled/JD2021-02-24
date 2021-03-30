package by.it.kaminskii.jd01_13;/* created by Kaminskii Ivan
 */

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    static double[] num = new double[1];
    static int size = 0;
    static String strnumber = "";

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        strnumber = scanner.next();
        readData();
    }

    static void readData() throws InterruptedException {
//        try {
        for (int i = 0; i < num.length; i++) {
            if (size == num.length) num = Arrays.copyOf(num, (size * 3 / 2 + 1));
            num[i] = Double.parseDouble(strnumber);
            System.out.println("rere" +num[i] +"rere");
            size++;
//            }
//        }catch (Exception e){
//            Thread.sleep(100);
//            for (int i = 0; i < num.length; i++) {
//                System.out.println(num[i]);
//            }
//        }
        }
    }
}
