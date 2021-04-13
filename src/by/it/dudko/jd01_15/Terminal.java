package by.it.dudko.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
        navigator.setCommand(this);
        console.executeCommand(this);
    }

    public void alert(String message) throws TerminalException {
        console.alert(message);
        console.executeCommand(this);
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

        private Path dirPath = null;

        private Command command;

        private Navigator(Path runnerPath) {
            cwd = runnerPath;
        }

        public Path getCwd() {
            return cwd;
        }

        public Path getDirPath() {
            return dirPath;
        }

        public Command getCommand() {
            return command;
        }


        public void setCommand(Terminal terminal) throws TerminalException {

            if (terminal.command.equalsIgnoreCase(Command.CD.name())) {
                command = Command.CD;
            } else if (terminal.command.equalsIgnoreCase(Command.DIR.name())) {
                command = Command.DIR;
            } else {
                throw new TerminalException(String.format("\"%s\" не является допустимой командой", terminal.command));
            }
            Path path;
            path = Paths.get(terminal.argument);
            processPath(path);

        }

        private void processPath(Path path) throws TerminalException {
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
                setPath(resultPath);
                // cwd = resultPath;
            }
        }

        private void setPath(Path resultPath) {
            // DIR command does not change current working directory
            // but may display other directory content
            if (Objects.equals(command, Command.CD)) {
                cwd = resultPath;
                dirPath = null;
            } else if (Objects.equals(command, Command.DIR)) {
                dirPath = resultPath;
            }
        }
    }

    private static class Console {

        public static final String DIR_LABEL = "<DIR>";
        private static final DateTimeFormatter DATE_FORMATTER =
                DateTimeFormatter.ofPattern("dd.MM.yyyy  HH:mm");
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
                    "dir <path to directory>" +
                    "end\n" +
                    "You are at \"home\" directory now";
            output.println(greeting);
        }

        public void executeCommand(Terminal terminal) {
            Command command = terminal.navigator.getCommand();
            if (Objects.equals(command, Command.CD)) {
                pwd(terminal.navigator.getCwd().toString());
            } else if (Objects.equals(command, Command.DIR)) {
                listDir(terminal.navigator.getDirPath());
                pwd(terminal.navigator.getCwd().toString());
            }
        }

        public void pwd(String pathString) {
            output.printf("\n%s>", pathString);
        }

        public void listDir(Path dir) {
            String dirItemInfo;
            try {
                output.println("\nСодержимое каталога " + dir);
                Stream<Path> dirList = Files.list(dir);
                Iterator<Path> dirIterator = dirList.iterator();
                Path dirObj;
                while (dirIterator.hasNext()) {
                    dirObj = dirIterator.next();
                    FileTime lastModifiedTime = Files.getLastModifiedTime(dirObj);
                    String formattedDate = formatDateTime(lastModifiedTime);
                    Path fileName = dirObj.getFileName();
                    if (Files.isDirectory(dirObj)) {
                        dirItemInfo = String.format("%s\t%5s\t%10s %s", formattedDate, DIR_LABEL, "", fileName);
                    } else {
                        // int fileSize = (int) (Files.size(dirObj) / 1024);
                        String strFileSize = String.format(Locale.US, "%,d", Files.size(dirObj))
                                .replace(',', ' ');
                        dirItemInfo = String.format("%s\t%5s\t%10s %s", formattedDate, "", strFileSize, fileName);
                    }
                    output.println(dirItemInfo);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public void alert(String message) {
            output.println(message);
        }

        public static String formatDateTime(FileTime fileTime) {

            LocalDateTime localDateTime = fileTime
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            return localDateTime.format(DATE_FORMATTER);
        }
    }


}
