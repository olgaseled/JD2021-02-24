package by.it.maksimova.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) { // значит while (true)
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                Var resultVar = parser.evaluate(expression);
                printer.print(resultVar);
            } else {
                break;
            }
        }

    }
}
