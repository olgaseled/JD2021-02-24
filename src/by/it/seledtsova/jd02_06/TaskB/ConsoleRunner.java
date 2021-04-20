package by.it.seledtsova.jd02_06.TaskB;

import java.io.File;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line; // будем читать строку
        Logger logger = Logger.INSTANCE;
        logger.setLoggerFile(new File(FilePath.getFilePath(Configuration.LOG_NAME, Logger.class)));
        VarStore.load();
        Parser parser = new Parser(); // будем передавать вычисления
        Printer printer = new Printer(); // будем передавать их результат
       while (true ) {
            String expression = scanner.nextLine();
            logger.log(expression);
            if (!expression.equals("end")) { //до тех пор, пока это выражение НЕ равняется end , мы их будм читать
                try {
                    Var result = parser.calc(expression); //передадим вычисления в parser
                    printer.print(result);
                } catch (CaltExeption e) {
                    printer.print(e);
                }
            } else {
                try {
                    VarStore.save(Var.getVars());
                } catch (CaltExeption e) {
                    printer.print(e);
                }
                break;
            }
        }
    }
}



