package by.it.kishkar.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    static Scanner scanner;
    static List<Double> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();


    }

    static void readData() throws Exception {
        int error=0;
        while (true) try {
            String consoleText = scanner.nextLine();
            numbers.add(Double.parseDouble(consoleText));
        } catch (Exception e) {
            Thread.sleep(100);
            for (int i = numbers.size(); i > 0; i--) {
                System.out.print(numbers.get(i - 1) + " ");
            }
            error++;
            if (error == 5) {
                throw new Exception();
            }

        }

    }

}
