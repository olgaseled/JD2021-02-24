package by.it.belazarovich.Calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalkExeption {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
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
