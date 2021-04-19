package by.it.maksimova.jd02_05.txt;

import by.it.maksimova.jd02_05.Language;
import by.it.maksimova.jd02_05.Messages;
import by.it.maksimova.jd02_05.User;

import java.util.Locale;

//  Locale locale = new Locale("ru", "RU");
public class Runner {
    public static void main(String[] args) {
        Language language = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);

if (args.length==2){
    language.setLocale(new Locale(args[0],args[1]) );
}

        System.out.println(language.get(Messages.WELCOME));
        System.out.println(language.get(Messages.QUESTION));
        System.out.println(language.get(User.NAME));
        System.out.println(language.get(User.LAST_NAME));
    }
}
