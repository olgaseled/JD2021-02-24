package by.it.dudko.jd01_15;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Terminal {
    private String command;
    private String argument;

    private final Parser parser;
    private final Navigator navigator;
    private final Console console;

    public Terminal(Path runnerPath) {
        parser = new Parser();
        navigator = new Navigator(runnerPath);
        console = new Console(System.out);
        console.welcome();
        console.pwd(navigator.getCwd().toString());
    }

    public void process(String commandStr) throws TerminalException {
        parser.parseCommand(this, commandStr);
        navigator.validateCommand(this);
        console.displayCommand(this);
    }

    public void alert(String message) {
        console.alert(message);
        console.displayCommand(this);
    }


    private static class Parser {

        private final Pattern commandPattern = Pattern.compile("[^\\s.]+");

        private Parser() {
        }

        void parseCommand(Terminal terminal, String inputLine) throws TerminalException {
            inputLine = inputLine.trim();
            Matcher commandMatcher = commandPattern.matcher(inputLine);
            if (!commandMatcher.find()) {
                throw new TerminalException("Command not found " + inputLine);
            } else {
                terminal.command = commandMatcher.group();
                terminal.argument = inputLine.substring(commandMatcher.end()).trim();
            }
        }
    }

    private static class Navigator {
        private Path cwd;

        private Command command;

        private Navigator(Path runnerPath) {
            cwd = runnerPath;
        }

        public Path getCwd() {
            return cwd;
        }

        public Command getCommand() {
            return command;
        }


        public void validateCommand(Terminal terminal) throws TerminalException {

            if (terminal.command.equalsIgnoreCase(Command.CD.name())) {
                command = Command.CD;
            } else if (terminal.command.equalsIgnoreCase(Command.DIR.name())) {
                command = Command.DIR;
            } else {
                throw new TerminalException(String.format("\"%s\" не является допустимой командой", terminal.command));
            }
            Path path;
            path = Paths.get(terminal.argument);
//            if (!Files.exists(path) || !Files.isDirectory(path)) {
//                throw new TerminalException("Path doesn't exist " + path);
//            }
            // processCommand(terminal.argument);
            processCommand(path);

        }

        private void processCommand(Path path) throws TerminalException {
            Path resultPath = cwd;
            String targetPath = path.toString();
            switch (targetPath) {
                case "..":
                    if (!Objects.isNull(cwd.getParent())) {
                        resultPath = cwd.getParent();
                    }
                    break;
                case ".":
                    resultPath = cwd;
                    break;
                default:
                    if (path.isAbsolute()) {
                        resultPath = path;
                    } else if (path.toString().startsWith("\\")) {
                        resultPath = path.getRoot().toAbsolutePath();
                    } else {
                        resultPath = Paths.get(cwd + File.separator + targetPath)
                                .toAbsolutePath()
                                .normalize();
                    }
            }
            if (!Files.exists(resultPath)) {
                throw new TerminalException("Path doesn't exist " + resultPath.toString());
            } else {
                cwd = resultPath;
            }
        }
    }

    private static class Console {

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
                    "You are at \"home\" directory now";
            output.println(greeting);
        }

        public void displayCommand(Terminal terminal) {
            Path dir = terminal.navigator.getCwd();
            Command command = terminal.navigator.getCommand();
            if (Objects.equals(command, Command.CD)) {
                pwd(dir.toString());
            }
        }

        public void pwd(String pathString) {
            output.printf("\n%s>", pathString);
        }

        public void dir(String line) {
            output.println(line);
        }

        public void alert(String message) {
            output.println(message);
        }
    }


}
