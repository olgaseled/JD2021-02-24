package by.it.seledtsova.jd02_05;

import java.text.DateFormat;
import java.util.Locale;

public interface Data {

    Locale ru = new Locale("ru","RU");
    DateFormat sdRu = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, ru);
      //  System.out.println(sdRu.format(new Date()));

    Locale be = new Locale("be","BY");
    DateFormat sdBe = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, be);
      //  System.out.println(sdBe.format(new Date()));

    Locale en = new Locale("en","US");
    DateFormat sdEn = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, en);
      //  System.out.println(sdEn.format(new Date()));
}
