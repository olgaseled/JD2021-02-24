package by.it.dudko.sandbox;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StreamsWriters {

    static Charset charset = StandardCharsets.ISO_8859_1;

    public static void main(String[] args) {

    }
    private static void writeToFile(String absSavePath, String text) {
        // The Java.io.BufferedWriter class writes text to a character-output stream,
        // buffering characters so as to provide for the efficient writing of single characters, arrays, and strings
        // The Java.io.OutputStreamWriter class is a bridge from character streams to byte streams.
        // Characters written to it are encoded into bytes using a specified charset.
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
}
