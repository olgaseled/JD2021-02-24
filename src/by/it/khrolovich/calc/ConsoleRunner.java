package by.it.khrolovich.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        Language lang = Language.INSTANCE;
        for (; ; ) {
            String expression = scanner.nextLine();
            Logger.get().log(expression);

            if (!expression.equals("end")) {
                switch (expression) {
                    case "be":
                        lang.setLocale(new Locale("be", "BY"));
                        break;
                    case "ru":
                        lang.setLocale(new Locale("ru", "RU"));
                        break;
                    case "en":
                        lang.setLocale(Locale.ENGLISH);
                        break;
                    default:
                        try {
                            Var resultVar = parser.evaluate(expression);
                            printer.print(resultVar);
                        } catch (CalcException e) {
                            printer.print(e);
                        }
                }

            } else {
                //сохранение из Var
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
