package by.it.kaminskii.jd02_01;/* created by Kaminskii Ivan
 */

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<String, Double> testMap = new HashMap<>(10, 0.75f);
        testMap.put("1", 1.0);
        testMap.put("2", 2.0);
        testMap.put("3", 3.0);
        testMap.put("4", 4.0);
        testMap.put("5", 5.0);
        testMap.put("6", 6.0);
        testMap.put("7", 7.0);
        testMap.put("8", 8.0);
        testMap.put("9", 9.0);
        testMap.put("10", 10.0);

        String testString = testMap.keySet().toString();
        testString = testString.replaceAll("[\\[\\],]","");
        String[] split = testString.split(" ");
        for (String s : split) {
            System.out.print(s);
        }

        System.out.println(testString);

    }
}
