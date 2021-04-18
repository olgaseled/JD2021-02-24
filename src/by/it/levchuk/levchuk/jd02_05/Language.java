package by.it.levchuk.levchuk.jd02_05;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;
    private final String RESBASA = "by.it.levchuk.levchuk.jd02_05.resources.language";

    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }
    public final void setLocale(Locale locale){
        bundle=ResourceBundle.getBundle(RESBASA, locale);
    }
    public String get(String key){
       return bundle.getString(key);
    }
}
