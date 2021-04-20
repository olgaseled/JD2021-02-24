package by.it.kirichenko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {

    INSTANCE;

    @SuppressWarnings("FieldCanBeLocal")
    private final String BASE = "by.it.kirichenko.jd02_05.resources.lang";

    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    final void setLocale(Locale locale) {

        bundle = ResourceBundle.getBundle(BASE, locale);
    }

    String get(String key) {
        return bundle.getString(key);
    }
}
