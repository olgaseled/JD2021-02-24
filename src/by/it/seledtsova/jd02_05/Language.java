package by.it.seledtsova.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;
    private final String LANGUAGE_PLACE = "by.it.seledtsova.jd02_05.resourses.language"; // где искать переводы

    ResourceBundle bundle;// выбираем ResourceBundle в java.util, те в самом языке

    Language() {
        setLocale(Locale.getDefault());
    }


    final void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle(LANGUAGE_PLACE, locale);
    }

    String get(String key) {
       return bundle.getString(key);
    }
}
