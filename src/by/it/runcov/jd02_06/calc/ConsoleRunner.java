package by.it.runcov.jd02_06.calc;

import java.io.File;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        VarRepository.load();
        LoggerCalc logger = LoggerCalc.INSTANCE;
        logger.setLogFile(new File(FileNameHelper.getFilePath("logfile.txt",LoggerCalc.class)));
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
