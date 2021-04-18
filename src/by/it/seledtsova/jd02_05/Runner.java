package by.it.seledtsova.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner implements Data {


    public static void main(String[] args) {
    //    Date date=new Date();
    //    System.out.println(date.toString());

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
        System.out.println(sdRu.format(new Date()));

    }

}

