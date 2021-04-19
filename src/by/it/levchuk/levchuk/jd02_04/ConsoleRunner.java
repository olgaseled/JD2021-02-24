package by.it.levchuk.levchuk.jd02_04;

import java.io.File;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        VarRepository.loading();
        LoggerCalc logger = LoggerCalc.LOGGING;
        logger.setLogFile(new File(FileNameHelper.getFilePath(Settings.LOG_FILE,LoggerCalc.class)));
        for (; ; ) {
            String exspression = scanner.nextLine();
            if (!exspression.equals("end")) {
                try {
                    Var resultVar = parser.analyze(exspression);
                    printer.print(resultVar);
                    try {
                        VarRepository.save(Var.vars);
                    } catch (CalcException e) {
                        printer.print(e);
                    }
                } catch (CalcException e) {
                    e.printStackTrace();
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
