package by.it.kaminskii.jd02_05;/* created by Kaminskii Ivan
 */

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Language lang = Language.INSTANCE;
        changeLanguage(lang);


        System.out.println(lang.get(Messages.WELCOME));
        System.out.println(lang.get(Messages.QUESTUIONS));
        System.out.println(lang.get(UserName.FIRST_NAME));
        System.out.println(lang.get(UserName.LAST_NAME));
        LocalDate data = LocalDate.now();
        System.out.println(data);
    }

    static void changeLanguage(Language lang) {
        System.out.println(Messages.CHANGE_LANGUAGE);
        String changeLang = scanner.next();
        if (changeLang.equals("BY")) {
            lang.setLocale(new Locale("be", "BY"));
        } else if (changeLang.equals("RU")) {
            lang.setLocale(new Locale("ru", "RU"));
        } else {
            lang.setLocale(Locale.getDefault());
        }
    }
}