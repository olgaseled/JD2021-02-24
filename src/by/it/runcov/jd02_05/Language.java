package by.it.runcov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;

    private final String BASE = "by.it.runcov.jd02_05.resources.language";
    ResourceBundle rb;

    Language() {
        setLocale(Locale.getDefault());
    }

    final void setLocale(Locale locale) {
        rb = ResourceBundle.getBundle(BASE, locale);
    }

    String get(String key) {
        return rb.getString(key);
    }
}

