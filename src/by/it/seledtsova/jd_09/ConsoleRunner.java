package by.it.seledtsova.jd_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line;

        Parsel parser=new Parsel();
        Printer printer=new Printer();

       while (!(line=scanner.nextLine()).equals("end")) {
           Var result=parser.calc(line);
           printer.print(result);
       }

    }

}
