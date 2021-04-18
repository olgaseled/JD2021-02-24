package by.it.levchuk.levchuk.jd02_05.txt;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Locale locale =new Locale("x");
        String res = "by.it.levchuk.levchuk.jd02_05.resources.language";
        ResourceBundle bundle = ResourceBundle.getBundle(res,locale);
        bundle.getString("messages.welcome");
        String s = bundle.getString("messages.welcome");
        System.out.println(s);
    }
}
