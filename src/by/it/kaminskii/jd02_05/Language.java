package by.it.kaminskii.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;

    String base = "by.it.kaminskii.jd02_05.prop.language";
    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    final void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(base,locale);
    }

    String get(String key){
        return bundle.getString(key);
    }
}
