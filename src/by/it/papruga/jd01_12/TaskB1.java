package by.it.papruga.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();

        for (; ; ) {
            String words = scanner.nextLine();
            if (!words.equals("end"))
                text.append(words).append("\n");
            else break;
        }

        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            map.put(matcher.group(), 0);
        }

        matcher.reset();

        while (matcher.find()) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().equals(matcher.group())) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }

        System.out.println(map);
    }

}
