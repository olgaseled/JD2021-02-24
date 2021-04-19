package by.it.seledtsova.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner  {


    public static void main(String[] args) {


        Language language = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH); // так можно конкретно указать какая locale
        Scanner scannerLocale=new Scanner(System.in);
        Date dateLocale=new Date();
        String country="";
        String chooseLanguage="";
        switch (scannerLocale.next()) {
            case "en":
                country = "US";
                chooseLanguage = "en";
                break;
            case "ru":
                country = "RU";
                chooseLanguage = "ru";
                break;
            case "be":
                country = "BY";
                chooseLanguage = "be";
               break;
            default:
                if (args.length == 2) {
                    language.setLocale(new Locale(args[0], args[1]));
                }
        }
        language.setLocale(new Locale(chooseLanguage,country));
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.forLanguageTag(chooseLanguage));
/*
        Locale en = new Locale("en","US");
        DateFormat sdEn = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, en);
        System.out.println(sdEn.format(new Date()));
  */

        System.out.println(language.get(Messages.WELCOME));
        System.out.println(language.get(Messages.QUESTION));
        System.out.println(language.get(User.FIRST_NAME));
        System.out.println(language.get(User.LAST_NAME));
        System.out.println(dateFormat.format(dateLocale));

    }

}

