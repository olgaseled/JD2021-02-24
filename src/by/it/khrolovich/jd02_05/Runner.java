package by.it.khrolovich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Language lang = Language.INSTANCE;
        if(args.length==2){
             lang.setLocale(new Locale(args[0],args[1]));
        }

        System.out.println(lang.get(Message.WELCOM));
        System.out.println(lang.get(Message.QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
    }
}
