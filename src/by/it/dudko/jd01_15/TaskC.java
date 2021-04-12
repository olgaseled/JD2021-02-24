package by.it.dudko.jd01_15;


import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {


    public static void main(String[] args) {
        String runnerStringPath = FileNameHelper.getFullPath("", TaskC.class);
        Path runnerPath = Paths.get(runnerStringPath);
        Navigator nav = new Navigator(runnerPath);
        CommandLine cmd = new CommandLine(nav);
        Scanner sc = new Scanner(System.in);

        String command;
        while (!(command= sc.nextLine()).equalsIgnoreCase("end")) {

        }
    }

    public static class CommandParser {
        enum Command {
            CD, DIR, END
        }

        Command command;
        String directory;

        public CommandParser() {
        }

        void parseCommand(String input) {
            input = input.trim().toUpperCase();
            String[] tokens;
            if (input.startsWith(Command.CD.name())) {
                tokens = input.split(Command.CD.name());
            }
        }
    }

    public static class Navigator {
        private final Path home;

        private final Path currDir;

        public Navigator(Path home) {
            this.home = home;
            this.currDir = home;
        }

        public String getHomeDir() {
            return home.toString();
        }

        public String getCurrDir() {
            return currDir.toString();
        }

        public void chdir(Path path) {

        }
    }

    static class CommandLine {

        private Navigator nav;
        private Console console;

        public CommandLine(Navigator nav) {
            this.nav = nav;
            this.console = new Console(System.out);
            console.welcome();
            console.pwd(nav.getHomeDir());
        }

        static class Console {

            private final PrintStream output;

            private Console(PrintStream output) {
                this.output = output;
            }

            public void welcome() {
                String greeting = "==================\n" +
                        "WELCOME TO CONSOLE\n" +
                        "==================\n" +
                        "available commands:\n" +
                        "cd ..\n" +
                        "cd <dir from current directory>\n" +
                        "dir\n" +
                        "end\n" +
                        "You are at \"home\" directory now\n";
                output.println(greeting);
            }

            public void pwd(String line) {
                output.println(line + ">");
            }

            public void dir(String line) {
                output.println(line);
            }
        }

    }



}
