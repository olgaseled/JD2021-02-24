package by.it.zmushko.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class ChangeLanguage {

    Scanner scan = new Scanner(System.in);

    public void changeLang(Language lang) {
        System.out.println(Messages.ASK_CHOOSE_LANG);
        for (; ; ) {
            String line = scan.nextLine();
            if (!line.equals(Messages.EXIT_PROGRAM)) {
                switch (line) {
                    case "BY" -> lang.setLocale(new Locale("be", "BY"));
                    case "RU" -> lang.setLocale(new Locale("ru", "RU"));
                    default -> lang.setLocale(Locale.getDefault());
                }
            } else {
                break;
            }
        }
    }
}
