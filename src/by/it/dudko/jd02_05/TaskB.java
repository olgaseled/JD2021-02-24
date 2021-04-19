package by.it.dudko.jd02_05;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    static Scanner sc;
    static String userLang;
    static Language lang;
    static DateTimeFormatterBuilder formatBuilder;

    public static void main(String[] args) {
        lang = Language.INSTANCE;
        formatBuilder = new DateTimeFormatterBuilder();
        sc = new Scanner(System.in);
        do {
            listenChangeLang();
            setLocale();
            greeting(lang);
        } while (repeat());
        goodBye();
    }

    private static void setLocale() {
        switch (userLang) {
            case "ru":
                lang.setLocale(new Locale("ru", "RU"));
                break;
            case "be":
                lang.setLocale(new Locale("be", "BY"));
                break;
            case "en":
                lang.setLocale(new Locale("en", "US"));
                break;
        }
    }

    private static boolean repeat() {
        do {
            System.out.println("Continue? Y/N");
            String answer = sc.nextLine().trim();
            if (answer.equalsIgnoreCase("Y")) return true;
            else if (answer.equalsIgnoreCase("N")) return false;
        } while(true);
    }

    private static void listenChangeLang() {
        do {
            System.out.println("Choose language from list: ru be en");
            userLang = sc.nextLine().trim().toLowerCase();
            try {
                Languages.valueOf(userLang.toUpperCase());
                break;
            } catch (IllegalArgumentException ignored) {
            }
        } while(true);
    }

    private static void greeting(Language lang) {

        Date date = new Date();
        Locale currentLocale = lang.getBundleLocale();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, currentLocale);
        System.out.println(dateFormat.format(date));
        System.out.printf("%s, %s %s!\n",
                lang.get(Messages.WELCOME),
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME)
        );
        System.out.println(lang.get(Messages.QUESTION));
    }

    private static void goodBye() {
        System.out.printf("%s, %s!",
                lang.get(Messages.BYE),
                lang.get(User.FIRST_NAME));
    }
}
