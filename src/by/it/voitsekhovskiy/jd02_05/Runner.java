package by.it.voitsekhovskiy.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Language lang = Language.INSTANCE; // ?
        if(args.length == 2) {
            lang.setLocale(new Locale(args[0], args[1]));
        }
        System.out.println(lang.get(Messages.WELCOME));
    }
}
