package by.it.dudko.sandbox;

import java.io.*;

public class Pipe {

    public static void main(String[] args) {
        try {
            // copy();
            transform();
            // sequence();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sequence() throws IOException {
        FileInputStream fis1 = new FileInputStream("src/by/it/dudko/sandbox/" + "even.txt");
        FileInputStream fis2 = new FileInputStream("src/by/it/dudko/sandbox/" + "odd.txt");
        SequenceInputStream combine = new SequenceInputStream(fis1, fis2);
        combine.transferTo(System.out);
    }

    private static void transform() throws IOException {
        FileInputStream fis = new FileInputStream("src/by/it/dudko/sandbox/" + "in.txt");
        FileOutputStream fos = new FileOutputStream("src/by/it/dudko/sandbox/" + "out2.txt");

        byte[] data = fis.readAllBytes();

        fis.close();

        ByteArrayInputStream byteInpStream = new ByteArrayInputStream(data);
        // ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        BufferedOutputStream bufOutStream = new BufferedOutputStream(fos);
        // int b;
        while(byteInpStream.available() > 0) {
            bufOutStream.write(byteInpStream.read() + 1);
            // byteOutStream.write(b + 1);
        }

        // byteOutStream.writeTo(bufOutStream);

        // byteOutStream.close();
        bufOutStream.close();

        // byte[] brokenData = byteOutStream.toByteArray();
        // fos.write(brokenData);



    }

    private static void copy() throws IOException {
        FileInputStream srcStream = new FileInputStream("src/by/it/dudko/sandbox/" + "in.txt");
        srcStream.transferTo(new FileOutputStream("src/by/it/dudko/sandbox/" + "out.txt"));
        srcStream.close();
    }




}
