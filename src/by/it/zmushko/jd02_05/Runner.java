package by.it.zmushko.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        final Language lang = Language.INSTANCE;
        final Locale locale = new Locale("be", "BY");

        System.out.println(lang.get(Messages.HELLO));
        System.out.println(lang.get(Messages.ASK_QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.SECOND_NAME));

    }
}
