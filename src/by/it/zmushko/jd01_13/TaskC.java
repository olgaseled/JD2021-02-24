package by.it.zmushko.jd01_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();
    }

    static void readData() throws Exception {
        int errorCount = 0;
        List<Double> objects = new ArrayList<>();
        while (true) {
            try {
                String text = scanner.nextLine();
                objects.add(Double.parseDouble(text));
            } catch (Exception e) {
                Thread.sleep(100);
                errorCount++;
                for (int i = objects.size(); i > 0; i--) {
                    System.out.print(objects.get(i-1) + " ");
                }
                System.out.println("err"+errorCount);
                if (errorCount == 5) {
                    throw new Exception();
                }
            }
        }
    }
}
