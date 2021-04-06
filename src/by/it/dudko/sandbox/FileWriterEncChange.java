package by.it.dudko.sandbox;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileWriterEncChange {
    public static void main(String[] args) throws Exception {

        try (
                // open input stream test.txt for reading purpose.
                FileReader fileReader = new FileReader("src/by/it/dudko/sandbox/out3utf8.txt", StandardCharsets.UTF_8);
                BufferedReader bis = new BufferedReader(fileReader);


                FileWriter fileWriter = new FileWriter("src/by/it/dudko/sandbox/out3.txt", Charset.forName("cp1251"));
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)

        ) {
            String line;
            // the file is read to the end
            while ((line = bis.readLine()) != null) {
                bufferedWriter.write(line);
            }

            // invokes flush to force bytes to be written out to baos
            bufferedWriter.flush();


        } catch (
                IOException e) {
            // if any IOException occurs
            e.printStackTrace();
        }
        // releases any system resources associated with the stream
    }

}
