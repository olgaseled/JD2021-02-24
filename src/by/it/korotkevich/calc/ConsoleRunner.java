package by.it.korotkevich.calc;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Logger logger = Logger.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        logger.log("Program started.", true);
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                try {
                    Var resultVar = parser.evaluate(expression);
                    printer.print(resultVar);
                    if (resultVar!=null){
                        logger.log(resultVar.toString(), true);
                    }
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                logger.log("Program terminated.\n", true);
                break;
            }
        }
    }
}
