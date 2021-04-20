package by.it.papruga.jd02_06_calc;


import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        VarRepository.load();
        Logger.getLogger().log("консоль открыта");

        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                try {
                    Var resultVar = parser.evaluate(expression);
                    Logger.getLogger().log("введено: " + expression);
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
        }
        Logger.getLogger().log("консоль закрыта");
    }
}
