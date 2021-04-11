package by.it.dudko.jd01_15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class TaskB {

    public enum Mode {
        OPEN, BLOCK, READ
    }

    static Charset charset = StandardCharsets.UTF_8;
    static String lineSep = System.getProperty("line.separator");
    /* Определить три режима обработки текста:
        - OPEN: режим открытого комментария
        - READ: режим чтения
    */
    static Mode mode = Mode.READ;

    public static void main(String[] args) {
        /*  Получить абсолютный путь к файлу с исполняемым классом.
            Для этого использовать утилитарный класс FileNameHelper
         */
        String simpleName = TaskB.class.getSimpleName() + ".java";
        String absClassPath = FileNameHelper.getFullPath(simpleName, TaskB.class);


        // Прочитать содержимое файла в StringBuilder переменную
        StringBuilder programText = new StringBuilder();
        readFileIntoStringBuilder(absClassPath, programText);

        String line, cleanLine;
        int lineEndPos;
        int from = 0, to;
        while ((lineEndPos = programText.indexOf(lineSep, from)) != -1) {
            to = lineEndPos;
            line = programText.substring(from, to);
            // Построчно обрабатывать текст, передавая в функцию анализа комментариев
            cleanLine = processLineRemoveComments(line, mode);
            if (line.length() > cleanLine.length()) {
                programText.replace(from, to, cleanLine);
            }
            from = to + lineSep.length();
            System.out.println(line);
        }

    }

    private static void readFileIntoStringBuilder(String absClassPath, StringBuilder programText) {
        try (
                InputStreamReader isr = new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(absClassPath
                                )
                        ), charset)
        ) {
            int ch;
            while ((ch = isr.read()) != -1) {
                programText.append((char) ch);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param lineStr - processed line of a program
     * @param mode    - current state of search
     *                "OPEN"
     * @return number of position in @line where comment
     * starts or closes. That depends on current @mode
     */
    static String processLineRemoveComments(String lineStr, Mode mode) {
        int start = 0;
        int end = lineStr.length(); // по умолчанию вся строка
        char currChar;
        char lineComment = '/';
        char blockComment = '*';
        for (int i = 0; i < lineStr.length(); i++) {
            currChar = lineStr.charAt(i);
            /* -> / */
            if (currChar == lineComment) {
                if (Objects.equals(mode, Mode.READ)) {
                    // потенциально начало комментария, выставляем режим
                    mode = Mode.OPEN;
                    start = i;
                } else if (Objects.equals(mode, Mode.OPEN)) {
                    // это строчный комментарий
                    break;
                } else if (Objects.equals(mode, Mode.BLOCK)) {
                    // закрылся блочный комментарий
                    end = i + 1; // substring + 1
                }
                /* -> * */
            } else if (currChar == blockComment) {
                if (Objects.equals(mode, Mode.OPEN)) {
                    // начало блочного комментария
                    mode = Mode.BLOCK;
                }

            } else {
                // сброс флага
                mode = Mode.READ;
            }

        }
        return lineStr.substring(start, end);
    }
}
