package by.it.maksimova.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;

    private final String BASE_NAME = "by/it/maksimova/jd02_05/resources.language";
    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

   public final void setLocale(Locale locale){
        bundle=ResourceBundle.getBundle(BASE_NAME,locale);
    }

    public String get(String key){
       return bundle.getString(key);
    }
}
