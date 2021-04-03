package by.it.dudko.sandbox;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Encoding {

    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void run() throws IOException {

        String strWord = "привет";
        String encodingAlias = "cp1251";
        String information;
        FileOutputStream fos = new FileOutputStream("src/by/it/dudko/sandbox/" + "out3.txt");

        StringBuilder hexWordBuilder = new StringBuilder();
        for (byte b : strWord.getBytes(encodingAlias)) {
            hexWordBuilder.append(Integer.toHexString(b & 0xFF));
        }
        information = String.format("hex dump байтов слова \"%s\" в кодировке %s: %s\n",
                strWord, encodingAlias, hexWordBuilder);
        fos.write(information.getBytes(encodingAlias));


        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        String hexWord = hexWordBuilder.toString();
        List<Integer> codePoints = new ArrayList<>(hexWord.length());
        information = String.format("hex dump %s в кодировке %s представляет слово \"", hexWord, encodingAlias);
        byteOut.writeBytes(information.getBytes(encodingAlias));
        for (int i = 1; i < hexWord.length(); i += 2) {
            String hexChar = String.format("%s%s", hexWord.charAt(i - 1), hexWord.charAt(i));
            int b = Integer.parseInt(hexChar, 16);
            byteOut.write(b);
            codePoints.add(b);
        }
        byteOut.writeBytes(String.format("\"\nМассив целочисленного представления байтов слова \"%s\" в кодировке %s: %s",
                strWord, encodingAlias, codePoints.toString())
                .getBytes(encodingAlias));
        byteOut.writeTo(fos);

    }
}
