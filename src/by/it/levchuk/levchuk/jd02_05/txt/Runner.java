package by.it.levchuk.levchuk.jd02_05.txt;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanLocal = new Scanner(System.in);
        Language lang = Language.INSTANCE;
        Locale.setDefault(Locale.ENGLISH);
        Date localDate = new Date();
        String country = "";
        String language = "";

        switch (scanLocal.nextLine()) {
            case "en":
                country = "US"; language = "en";
                break;

            case "ru":
                country = "RU"; language = "ru";
                break;

            case "be":
                country = "BY"; language = "be";
                break;

            default: if (args.length==2){
                country=args[0]; language=args[1];
            }
        }

    lang.setLocale(new Locale(language, country));
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(language, country));
        
        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTION));
        System.out.println(lang.get(User.FIRST_NAME));
        System.out.println(lang.get(User.LAST_NAME));
        System.out.println(lang.get(User.NICKNAME));
        System.out.println(lang.get(User.I_AM));
        System.out.println(lang.get(User.TEACHER));
        System.out.println(lang.get(User.LEVEL));
        System.out.println(df.format(localDate));
    }
}
