package by.it.levchuk.levchuk.jd02_05;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;
    private String res = "by.it.levchuk.levchuk.jd02_05.resources.language";

    ResourceBundle bundle;

    Language() {
        bundl=ResourceBundle.getBundle(res, Locale.getDefault());
    }

    ResourceBundle bundl;
}
