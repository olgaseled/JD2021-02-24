package by.it.khrolovich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {

        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for(;;){
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                Var resultVar = null;
                try {
                    resultVar = parser.evaluate(expression);
                } catch (CalcException e) {
                    printer.printCalcException(e);
                }
                printer.print(resultVar);
            } else {
                break;
            }

        }
        Var var = VarCreator.build("{123, -45.6}");
        printer.print(var);
    }
}
