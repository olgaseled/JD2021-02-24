package by.it.khrolovich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                try {
                    Var resultVar = parser.evaluate(expression);
                    printer.print(resultVar);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                //сохранение из Var
                try {
                    VarRepository.save(Var.vars);
                } catch (CalcException e) {
                    printer.print(e);
                }
                break;
            }
        }
    }
}
