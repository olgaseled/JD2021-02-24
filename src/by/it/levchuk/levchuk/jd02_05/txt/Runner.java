package by.it.levchuk.levchuk.jd02_05.txt;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);


        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(lang.get(User.NICKNAME));
        System.out.println(lang.get(User.I_AM));
        System.out.println(lang.get(User.TEACHER));
        System.out.println(lang.get(User.LEVEL));

    }
}
