package by.it.savchenko.calc;


import java.io.File;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);

        VarRepository.load();
        EnumLogger logger = EnumLogger.INSTANCE;
        String LOGGER_FILE="LoggerFile.txt";
        logger.setFile(new File(FileNameHelper.getFilePath(LOGGER_FILE,EnumLogger.class)));
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                try {
                    Var resultVar = parser.calc(expression);
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
