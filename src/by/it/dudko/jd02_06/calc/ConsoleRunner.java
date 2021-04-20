package by.it.dudko.jd02_06.calc;

import by.it.dudko.jd02_06.FileNameHelper;

import java.io.File;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser(new VarCreator());
        Scanner scanner = new Scanner(System.in);
        LoggerEnum logger = LoggerEnum.INSTANCE;
        logger.setLogFile(
                new File(
                        FileNameHelper.getFullPath(
                                Config.LOG_FILE_NAME,
                                LoggerEnum.class
                        )
                )
        );
        VarRepository.load();
        for (; ; ) {
            String expression = scanner.nextLine();
            // log expression to calculate or exit command
            logger.log(expression);
            if (!expression.equals("end")) {
                try {
                    Var resultVar = parser.evaluate(expression);
                    printer.print(resultVar);
                } catch (CalcException e) {
                    printer.print(e);
                }
            } else {
                try {
                    VarRepository.save(Var.getVars());
                } catch (CalcException e) {
                    printer.print(e);
                }
                break;
            }
        }
    }
}
