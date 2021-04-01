package by.it.kaminskii.jd01_13;/* created by Kaminskii Ivan
 */
/* презентация сегодняшняя решение*/
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class TaskC {

    static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();
    }

    static void readData() throws Exception {
        int err = 0;
        List<Double> numbers = new ArrayList<>();
        while (true) {
            try {
                String consoleText = scanner.nextLine();
                numbers.add(Double.parseDouble(consoleText));
            } catch (Exception e) {
                Thread.sleep(100);
                for (int i = numbers.size(); i > 0; i--) {
                    System.out.print(numbers.get(i - 1) + " ");
                }
                err++;
                if (err == 5) {
                    throw new Exception();
                }
//        strnumber.add();

            }
        }
    }
}


