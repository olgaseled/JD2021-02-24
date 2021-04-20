package by.it.dudko.jd02_05.calc;

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
        Language lang = Language.INSTANCE;
        printer.print(lang.get(Messages.WELCOME));
        for (; ; ) {
            String expression = scanner.nextLine();
            // log expression to calculate or exit command
            logger.log(expression);
            if (!expression.equalsIgnoreCase(Config.STOP_WORD)) {
                try {
                    Languages.valueOf(expression.trim().toUpperCase());
                    lang.setLocale(expression.trim().toLowerCase());
                } catch (IllegalArgumentException ignored) {
                }
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
                printer.print(lang.get(Messages.BYE));
                break;
            }
        }
    }
}
