package by.it.korotkevich.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Locale.setDefault(Locale.UK);

        System.out.println("Choose language (en - english, be - belarusian, ru - russian).");
        System.out.println("Type end to terminate program");
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String language = scanner.nextLine();
            String country;
            if (!language.equals("end")) {
                if ("be".equals(language)) {
                    country = "BY";
                } else if ("ru".equals(language)) {
                    country = "RU";
                } else {
                    language = "en";
                    country = "UK";
                }

                Locale current = new Locale(language, country);
                ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.korotkevich.jd02_05.res.text", current);

                System.out.println(resourceBundle.getString("welcome.message"));
                System.out.print(resourceBundle.getString("welcome.date"));
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, current);
                String date = df.format(new Date());
                System.out.println(date);
            } else {
                break;
            }
        }
    }
}
