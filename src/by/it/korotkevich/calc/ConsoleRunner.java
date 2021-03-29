package by.it.korotkevich.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                Var resultVar = null;
                try {
                    resultVar = parser.evaluate(expression);
                    printer.print(resultVar);
                } catch (CalcException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }
}
