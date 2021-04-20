package by.it.maksimova.calculator;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        VarRepository.load();
        for (; ; ) {
            Var resultVar = null;
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                try {
                    resultVar = parser.evaluate(expression);
                    printer.print(resultVar);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                try {
                    VarRepository.save(Var.vars);
                } catch (CalcException e) {
                    printer.print(e);
                }
                break;
            }

            for (int i = 0; i < 2; i++) {
                Var finalResultVar = resultVar;
                new Thread(() -> {
                    Logger logger = Logger.getLogger();
                    logger.log(finalResultVar.toString());
                }).start();
            }
        }
    }
}
