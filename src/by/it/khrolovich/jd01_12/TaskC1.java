package by.it.khrolovich.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> hashMap = new HashMap<>();
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        int key = 1;
        while (true) {
            String word = scanner.next();
            if (word.equals("end")) {
                break;
            }
            hashMap.put(key, word);
            key++;
        }
        System.out.println(hashMap.toString());

        Iterator<String> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            if (!hashSet.add(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println(hashMap.toString());

    }
}
