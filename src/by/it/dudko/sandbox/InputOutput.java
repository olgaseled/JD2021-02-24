package by.it.dudko.sandbox;

import java.io.*;
import java.util.Arrays;

public class InputOutput {

    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void run() throws IOException {

        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;

        String srcFileName = "src/by/it/dudko/sandbox/" + "one.txt";
        String outFileName = "src/by/it/dudko/sandbox/" + "ten.txt";

        int i = 0, ch = 0;
        int emojiLength = 5;
        int copies = 10;
        byte[] maybeBom = new byte[3];

        try {
            fileInputStream = new FileInputStream(srcFileName);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(outFileName);

            bufferedInputStream.mark(0);
            if (bufferedInputStream.read(maybeBom, 0, 3) != -1 &&
                    Arrays.equals(maybeBom, new byte[]{-17, -69, -65})) {
                bufferedInputStream.mark(0); // set mark to byte after BOM
            }

            int totalChars = copies * emojiLength;
            while (i < totalChars) {
                if (bufferedInputStream.available() > 0) {
                    ch = bufferedInputStream.read();
                    System.out.print((char) ch);
                    fileOutputStream.write(ch);
                    i += 1;
                } else {
                    bufferedInputStream.reset();
                }
            }

        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            } else if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

}
