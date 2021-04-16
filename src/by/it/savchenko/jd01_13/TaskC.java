package by.it.savchenko.jd01_13;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();
    }

    static void readData() throws Exception {
        int error = 0;
        List<Double> list = new ArrayList<>();
        while (true) {
            try {
                String text = scanner.nextLine();
                list.add(Double.parseDouble(text));
            } catch (Exception e) {
                Thread.sleep(100);
                error++;
                for (int i = list.size(); i > 0; i--) {
                    System.out.print(list.get(i - 1) + " ");
                }
                System.out.println("error " + error);
                if (error == 5) {
                    throw new Exception();
                }
            }
        }
    }
}
