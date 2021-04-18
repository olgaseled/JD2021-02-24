package by.it.levchuk.levchuk.jd02_05.txt;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Locale locale =new Locale("x");
        bundle.getString("messages.welcome");
        String s = bundle.getString(Messages.WELCOME);
        System.out.println(s);
    }
}
