package by.it.kirichenko.jd02_05;

import java.util.Locale;

public class TaskA {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Language lang = Language.INSTANCE;
        if (args.length == 2) {
            lang.setLocale(new Locale(args[0], args[1]));
        }
        greeting(lang);
    }

    private static void greeting(Language lang) {
        System.out.printf("%s, %s %s!\n",
                lang.get(Messages.WELCOME),
                lang.get(User.FIRST_NAME),
                lang.get(User.LAST_NAME)
        );
        System.out.println(lang.get(Messages.QUESTION));
    }
}

