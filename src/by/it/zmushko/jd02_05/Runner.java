package by.it.zmushko.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ChangeLanguage changeLanguage = new ChangeLanguage();
        Locale.setDefault(Locale.ENGLISH);
        final Language lang = Language.INSTANCE;

        final OutMessages outAllMessages = new OutMessages();
        do {
            changeLanguage.changeLang(lang);
            outAllMessages.outAllMessages(lang);
        } while (!changeLanguage.scan.nextLine().equals("END"));

    }
}
