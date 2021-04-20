package by.it.dudko.jd02_05.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {

    INSTANCE;

    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    final void setLocale(Locale locale) {
        String bundleNamespace = Config.BUNDLE_NAMESPACE;
        this.bundle = ResourceBundle.getBundle(bundleNamespace, locale);
    }

    String get(String key) {
        return bundle.getString(key);
    }

    final void setLocale(String userLang) {
        switch (userLang) {
            case "ru":
                INSTANCE.setLocale(new Locale("ru", "RU"));
                break;
            case "be":
                INSTANCE.setLocale(new Locale("be", "BY"));
                break;
            case "en":
                INSTANCE.setLocale(new Locale("en", "US"));
                break;
        }
    }
}
