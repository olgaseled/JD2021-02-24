package by.it.seledtsova.jd02_05;

import java.text.DateFormat;
import java.util.Locale;

public interface Data {


    Locale en = new Locale("en","US");
    DateFormat sdEn = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, en);
      //  System.out.println(sdEn.format(new Date()));
}
