package by.it.savchenko.jd02_05;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Date;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner uiSetLocal = new Scanner(System.in);
        Locale.setDefault(Locale.ENGLISH);
        Language lang = Language.INSTANCE;
        Date localDate = new Date();
        String language = "";
        String country = "";

        switch (uiSetLocal.nextLine())
        {
            case "ru":
                language = "ru";
                country = "RU";
                break;
            case "be":
                language = "be";
                country = "BY";
                break;

            case "en":
                language = "en";
                country = "US";
                break;

            default: if (args.length==2){
                language = args[0];
                country = args[1];
            }
        }

        lang.setLocale(new Locale(language, country));
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(language, country));

        System.out.println(lang.get(Messages.WELCOME));
        System.out.print(lang.get(User.FIRST_NAME) + " ");
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(df.format(localDate));


    }

}
