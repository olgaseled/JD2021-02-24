package by.it.levchuk.levchuk.jd02_05;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        new Locale("ru","RU");
        String res = "by.it.levchuk.levchuk.jd02_05.resources.language";
        ResourceBundle bundle = ResourceBundle.getBundle(res);
        bundle.getString("messages.welcome");
        String s = bundle.getString("messages.welcome");
        System.out.println(s);
    }
}
