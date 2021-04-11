package by.it.dudko.jd01_15;

import java.io.*;
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
        - BLOCK: режим блочного комментария
        - READ: режим чтения
    */
    static Mode mode = Mode.READ;

    public static void main(String[] args) {
        /*  Получить абсолютный путь к файлу с исполняемым классом.
            Для этого использовать утилитарный класс FileNameHelper
         */
        String simpleName = TaskB.class.getSimpleName() + ".java";
        String absClassPath = FileNameHelper.getFullPath(simpleName, TaskB.class);
        String simpleResultName = TaskB.class.getSimpleName() + ".txt";
        String absSavePath = FileNameHelper.getFullPath(simpleResultName, TaskB.class);


        // Прочитать содержимое файла в StringBuilder переменную
        StringBuilder programText = new StringBuilder();
        StringBuilder cleanedText = new StringBuilder();
        readFileIntoStringBuilder(absClassPath, programText);

        String line, cleanLine;
        int lineEndPos;
        int from = 0, to;
        String newLine = "";
        while ((lineEndPos = programText.indexOf(lineSep, from)) != -1) {
            to = lineEndPos;
            line = programText.substring(from, to);
            // Построчно обрабатывать текст, передавая в функцию анализа комментариев
            cleanLine = processLineRemoveComments(line);
            cleanedText.append(newLine);
            cleanedText.append(cleanLine);
            from = to + lineSep.length();
            newLine = lineSep;
        }

        System.out.println(cleanedText);
        writeToFile(absSavePath, cleanedText.toString());

    }

    private static void writeToFile(String absSavePath, String text) {
        try (
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(absSavePath), charset)
                )
        ) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void readFileIntoStringBuilder(String absClassPath, StringBuilder programText) {
        try (
                InputStreamReader isr = new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(absClassPath)
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
     * Removes all Java comments from a given string
     *
     * @param lineStr - processed line of a program
     * @return cleaned line
     */
    static String processLineRemoveComments(String lineStr) {
        StringBuilder buffer = new StringBuilder();
        StringBuilder result = new StringBuilder();

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
                    // пока что пишем в буфер
                    buffer.append(currChar);
                } else if (Objects.equals(mode, Mode.OPEN)) {
                    // это строчный комментарий - строка обработана
                    break;
                } else if (Objects.equals(mode, Mode.BLOCK)) {
                    // закрылся блочный комментарий
                    // очистим буфер и читаем дальше
                    clearStringBuilder(buffer);
                    mode = Mode.READ;
                }
                /* -> * */
            } else if (currChar == blockComment) {
                if (Objects.equals(mode, Mode.OPEN)) {
                    // начало блочного комментария
                    mode = Mode.BLOCK;
                    // пока что пишем в буфер
                    buffer.append(currChar);
                } else if (!Objects.equals(mode, Mode.BLOCK)){
                    result.append(currChar);
                }
            } else if (Objects.equals(mode, Mode.BLOCK)) {
                // пишем в буфер блочный комментарий
                buffer.append(currChar);
            } else {
                // копируем буфер в вывод
                result.append(buffer);
                // пишем в результат
                result.append(currChar);
                // сброс флага
                mode = Mode.READ;
            }
        }
        return result.toString();
    }

    static void clearStringBuilder(StringBuilder sb) {
        sb.delete(0, sb.length());
    }
}
