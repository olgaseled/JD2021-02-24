package by.it.papruga.jd02_06.task_c;



import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        Time clock = new Time();
        VarRepository.load();
        Logger.getLogger().log("консоль открыта " + clock.getTime());

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
        Logger.getLogger().log("консоль закрыта "+ clock.getTime());
    }
}
