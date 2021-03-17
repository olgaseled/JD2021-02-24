package by.it.kirichenko.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        for (;;){
            String expr = scanner.nextLine();
            if(!expr.equals("end")){
                //TODO
            }
        }

       // Var var=VarCreator.build("{123, -45.6}");
       // System.out.println(var);
        //TODO
    }
}
