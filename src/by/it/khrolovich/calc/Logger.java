package by.it.khrolovich.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

public enum Logger {
    INSTANCE;

    //private static Logger logger;

    //объкт один - this
    synchronized void log(String message) {

        String filePath = FileNameHelper.getFilePath("log.txt", Logger.class);

        Language lang = Language.INSTANCE;
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, lang.getLocale());
        //DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",lang.getLocale());
        try(PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {

            printWriter.println(df.format(new Date())+": "+message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}