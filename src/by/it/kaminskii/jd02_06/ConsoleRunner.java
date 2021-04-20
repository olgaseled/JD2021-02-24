package by.it.kaminskii.jd02_06;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();


        while (!(line = scanner.nextLine()).equals("end")) {

            Var result = null;
            try {
                result = parser.calc(line);
            } catch (CalcExeption e) {
                try {
                    throw new CalcExeption((e));
                } catch (CalcExeption calcExeption) {
                    calcExeption.printStackTrace();
                }
            }
            printer.print(result);
        }
        Logger.getLogger().log(CalcLogOut.THE_END);
    }
}
