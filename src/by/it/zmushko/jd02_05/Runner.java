package by.it.zmushko.jd02_05;

import java.time.LocalDateTime;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ChangeLanguage changeLanguage = new ChangeLanguage();
        Locale.setDefault(Locale.ENGLISH);
        final Language lang = Language.INSTANCE;
        //if (args.length == 2) {
        //    lang.setLocale(new Locale(args[0], args[1]));
        //}

        System.out.println(lang.get(Messages.HELLO));
        System.out.println(lang.get(Messages.ASK_QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.SECOND_NAME));
        LocalDateTime data = LocalDateTime.now();
        System.out.println(data);

        changeLanguage.changeLang(lang);
        System.out.println(lang.get(Messages.HELLO));
        System.out.println(lang.get(Messages.ASK_QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.SECOND_NAME));
        LocalDateTime data2 = LocalDateTime.now();
        System.out.println(data2);

    }
}
