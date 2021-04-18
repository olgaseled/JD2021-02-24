package by.it.seledtsova.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner {


    public static void main(String[] args) {
    //    Date date=new Date();
    //    System.out.println(date.toString());

        Locale ru = new Locale("ru");
        DateFormat sdRu = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, ru);
        System.out.println(sdRu.format(new Date()));

        Locale be = new Locale("be");
        DateFormat sdBe = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, be);
        System.out.println(sdBe.format(new Date()));

        Locale en = new Locale("en");
        DateFormat sdEn = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, ru);
        System.out.println(sdEn.format(new Date()));

        Language language = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH); // так можно конкретно указать какая locale

        if (args.length==2) {
            language.setLocale(new Locale(args[0],args[1]));
        }
    //    Locale locale=new Locale("ru", "RU");// создали locale язык русский страна Россия

        System.out.println(language.get(Messages.WELCOME));
        System.out.println(language.get(Messages.QUESTION));
        System.out.println(language.get(User.FIRST_NAME));
        System.out.println(language.get(User.LAST_NAME));
    }

}

