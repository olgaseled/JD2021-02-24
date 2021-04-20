package by.it.zmushko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;
    private String LANG_PATH = "by.it.zmushko.jd02_05.resources.language";
    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    final void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(LANG_PATH, locale);
    }

    String get(String key) {
        return bundle.getString(key);
    }

}
