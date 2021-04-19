package by.it.runcov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.ENGLISH);
        Language lang = Language.INSTANCE;
        Date date = new Date();
        String language = "";
        String country = "";

        switch (scanner.nextLine()) {

            case "en":
                language = "en";
                country = "US";
                break;

            case "be":
                language = "be";
                country = "BY";
                break;

            case "ru":
                language = "ru";
                country = "RU";
                break;


            default:
                if (args.length == 2) {
                    language = args[0];
                    country = args[1];
                }
        }

        lang.setLocale(new Locale(language, country));
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale(language, country));


        System.out.println(lang.get(Massages.WELCOME));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(lang.get(Massages.QUESTION));
        System.out.println(df.format(date));
    }
}
