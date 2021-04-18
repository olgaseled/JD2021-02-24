package by.it.levchuk.levchuk.jd02_05.txt;

/*crash-noobik
Liauchuk Aliaksandr*/

import by.it.levchuk.levchuk.jd02_05.Language;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);
        if (args.length==2){
            lang.setLocale(new Locale(args[0],args[1]);
        }

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
