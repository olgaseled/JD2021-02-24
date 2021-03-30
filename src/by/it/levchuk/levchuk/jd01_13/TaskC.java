package by.it.levchuk.levchuk.jd01_13;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class TaskC {

    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();
    }
    static void readData() throws Exception {
        int error = 0;
        List<Double> errors = new ArrayList<>();
        while (true) {
            try {
                String text = scanner.nextLine();
                errors.add(Double.parseDouble(text));
            } catch (Exception e) {
                sleep(100);
                error++;
                for (int i = errors.size(); i > 0; i--) {
                    System.out.print(errors.get(i - 1) + " ");
                }
                System.out.println("err " + error);
                if (error == 5) {
                    throw new Exception();
                }
            }
        }
    }
}
