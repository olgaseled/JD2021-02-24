package by.it.dudko.jd01_15;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        String runnerStringPath = FileNameHelper.getFullPath("", TaskC.class);
        Path runnerPath = Paths.get(runnerStringPath);
        Terminal terminal = new Terminal(runnerPath);

        Scanner sc = new Scanner(System.in);

        String commandStr;
        while (!(commandStr = sc.nextLine()).equalsIgnoreCase("end")) {
            try {
                terminal.process(commandStr);
            } catch (TerminalException e) {
                terminal.alert(e.getMessage());
            }
        }
    }
}
