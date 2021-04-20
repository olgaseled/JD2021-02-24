package by.it.khrolovich.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Locale.setDefault(Locale.ENGLISH);
        Language lang = Language.INSTANCE;
        if (args.length == 2) {
            lang.setLocale(new Locale(args[0], args[1]));
        }

        System.out.println(lang.get(Message.WELCOM));
        System.out.println(lang.get(Message.QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, lang.getLocale());
        System.out.println(df.format(new Date()));

        for (; ; ) {
            String changeLocal = scanner.next();
            if (!changeLocal.equals("end")) {
                switch (changeLocal) {
                    case "be":
                        lang.setLocale(new Locale("be", "BY"));
                        break;
                    case "ru":
                        lang.setLocale(new Locale("ru", "RU"));
                        break;
                    default:
                        lang.setLocale(Locale.ENGLISH);
                }

                System.out.println(lang.get(Message.WELCOM));
                System.out.println(lang.get(Message.QUESTION));
                System.out.println(lang.get(User.FIRST_NAME));
                System.out.println(lang.get(User.LAST_NAME));

                df = DateFormat.getDateInstance(DateFormat.MEDIUM, lang.getLocale());
                System.out.println(df.format(new Date()));
            } else break;
        }
    }
}